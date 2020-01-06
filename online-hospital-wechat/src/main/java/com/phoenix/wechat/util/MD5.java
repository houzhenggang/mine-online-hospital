package com.phoenix.wechat.util;

import java.security.MessageDigest;
import com.phoenix.wechat.misc.BASE64Encoder;

/**
 * MD5加密算法
 *
 * @since 0.0.1
 */
public class MD5 {

    /**
     * 将字符串加密
     *
     * @param str 要加密的字符串
     * @return 加密后的字符串
     */
    public static String encryptByMd5(String str) {
        if (str == null) {
            return null;
        }
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            BASE64Encoder base64en = new BASE64Encoder();
            byte[] b = str.getBytes();
            byte[] digest = md5.digest(b);
            String newstr = base64en.encode(digest);
            return newstr;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
