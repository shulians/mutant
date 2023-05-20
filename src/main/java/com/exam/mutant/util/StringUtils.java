package com.exam.mutant.util;

import java.util.regex.Pattern;

public class StringUtils {
    public static boolean isMatch(String[] list, String text){
        String regex = "["+String.join(",", list)+"]*";
        Pattern p = Pattern.compile(regex);
        return p.matcher(text).matches();
    }
}
