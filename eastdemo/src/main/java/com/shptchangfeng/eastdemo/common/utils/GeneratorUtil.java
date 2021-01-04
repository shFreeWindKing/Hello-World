package com.shptchangfeng.eastdemo.common.utils;

import java.util.UUID;

public class GeneratorUtil {
    public static String getRandomUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
