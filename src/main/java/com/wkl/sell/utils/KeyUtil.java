package com.wkl.sell.utils;

import java.util.Random;

public class KeyUtil {
//生成主键
    public static synchronized String genUniqueKey(){
        Random random = new Random();
        Integer number = random.nextInt(900000)+100000;
        return System.currentTimeMillis()+String.valueOf(number);
    }
}
