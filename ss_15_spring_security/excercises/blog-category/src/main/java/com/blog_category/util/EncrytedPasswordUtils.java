package com.blog_category.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncrytedPasswordUtils {
    public static String encrytePassword(String passWord){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(passWord);
    }

    public static void main(String[] args) {
        String passWord = "Aa01205426612";
        String encrytedPassword = encrytePassword(passWord);

        System.out.println("pass:" + passWord + "\nencrytedPassword :" + encrytedPassword);
    }
}
