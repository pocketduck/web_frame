package com.xxl.app.base.security;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by 58 on 2016-12-13.
 */
public class SecurityUtilTest {
    String encodeValue = "88b0ad730ba24bcee42ca8cf78e87934c0d6b6461418b59df58c406b6bade144";///加密后密码
    String encode = "111111";//原始密码
    @Test
    public void testEncode() {
        String ecodeResult = SecurityUtil.encode(encode);
        System.out.println(ecodeResult);
        Assert.assertEquals(ecodeResult,encodeValue);
    }

    @Test
    public void testMatches() {
        boolean result = SecurityUtil.matches(encodeValue,encode);
        Assert.assertTrue(result);
    }
}
