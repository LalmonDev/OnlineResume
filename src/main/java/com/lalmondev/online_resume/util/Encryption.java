package com.lalmondev.online_resume.util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 *  MD5加密
 *  由于MD5难可逆，所以只能把传过来的密码进行MD5加密，再和数据库的MD5加密后字段比较
 */

public class Encryption {
    public String MD5Encryption(String content){
        return DigestUtils.md5Hex(content);
    }
}
