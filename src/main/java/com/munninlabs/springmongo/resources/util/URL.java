package com.munninlabs.springmongo.resources.util;

public class URL {

    public static String decodeParam(String text) {
        try{
            return java.net.URLDecoder.decode(text, "UTF-8");
        }
        catch (Exception e){
            return "";
        }
    }
}
