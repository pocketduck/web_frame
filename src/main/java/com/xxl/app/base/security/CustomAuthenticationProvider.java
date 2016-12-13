package com.xxl.app.base.security;

import java.util.ArrayList;
import java.util.List;

import com.xxl.app.base.bean.UserProfile;
import com.xxl.app.base.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Created by 58 on 2016-12-12.
 */
public class CustomAuthenticationProvider extends
         AbstractUserDetailsAuthenticationProvider {
    private static final Logger logger =  LoggerFactory.getLogger(CustomAuthenticationProvider.class);
    @Autowired
    private IUserService userService;

    private MessageSourceAccessor messages = SpringSecurityMessageSource.getAccessor();

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails,
                                                  UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        String encPass = userDetails.getPassword();//存储的加密密码
        String rowPass = (String)authentication.getCredentials();
        logger.info("登录失败 密码错误 username==" + userDetails.getUsername());
               if (!SecurityUtil.matches(encPass, rowPass)) {
            throw new AuthenticationServiceException(messages.getMessage("WrongPassword"));
        }
    }

    @Override
    protected UserDetails retrieveUser(String username,
                                       UsernamePasswordAuthenticationToken authentication)
            throws AuthenticationException {

        com.xxl.app.base.bean.User user = userService.findByUsername(username);
        System.out.println("User : "+user);
        if(user==null){
            logger.info("登录失败 用户不存在 userusername==" + username);
            throw new AuthenticationServiceException(messages.getMessage("WrongPassword"));
        }
        return new User(user.getUserName(), user.getPassword(),
                user.getState().equals("Active"), true, true, true, getGrantedAuthorities(user));
    }

    private List<GrantedAuthority> getGrantedAuthorities(com.xxl.app.base.bean.User user){
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        for(UserProfile userProfile : user.getUserProfiles()){
         authorities.add(new SimpleGrantedAuthority("ROLE_"+userProfile.getType()));
        }
        logger.info("登录 user==" +user.getUserName() +"角色==" + authorities);
        return authorities;
    }
}
