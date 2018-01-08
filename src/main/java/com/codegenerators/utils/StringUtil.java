package com.codegenerators.utils;

public class StringUtil {
	
	public static String toLowerCaseFirstOne(String s){
        if(Character.isLowerCase(s.charAt(0))) {
		    return s;
        } else {
		    return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
        }
	}

    public static String toUpperCaseFirstOne(String s){
		if(Character.isUpperCase(s.charAt(0))) {
		    return s;
		} else {
		    return (new StringBuilder()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
		}
	}

}
