package com.chexiao.platform.base.util;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by 58 on 2016-12-15.
 */
public class UniqueIDUtilsTest {

    @Test
    public void testGetId() throws Exception{
       long id =  UniqueIDUtils.getUniqueID();
        System.out.println("id==" + id);
        Assert.assertTrue( id > 0);
    }
}
