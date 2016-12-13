package com.xxl.app.base.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;

/**
 * Created by 58 on 2016-12-13.
 */
public class SecurityUtil {
   static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(11);
   static ShaPasswordEncoder shaEncoder = new ShaPasswordEncoder(256);
   static String salt = "safe";

    public static String encode (String pwd) {
        return shaEncoder.encodePassword(pwd,salt);
    }

    /**
     *
     * @param encPass 加密的密码
     * @param rawPass 验证的密码
     * @return 是否匹配
     */
    public static boolean matches (String encPass, String rawPass) {
       return  shaEncoder.isPasswordValid(encPass,rawPass,salt);
    }

}
