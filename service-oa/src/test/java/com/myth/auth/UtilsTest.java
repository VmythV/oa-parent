package com.myth.auth;

import com.myth.common.utils.MD5;
import org.junit.jupiter.api.Test;

public class UtilsTest {
    @Test
    void testMD5(){
        String encrypt = MD5.encrypt("111111");
        System.out.println(encrypt);
    }
}
