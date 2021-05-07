package com.cola.utils;


import org.junit.Test;

import java.util.UUID;

//@SuppressWarnings("all")   //抑制警告
public class IdUtil {

    public static String getId(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }

    @Test
    public void test(){
        System.out.println(IdUtil.getId());
    }
}
