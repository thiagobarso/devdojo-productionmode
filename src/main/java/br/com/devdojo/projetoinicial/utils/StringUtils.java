package br.com.devdojo.projetoinicial.utils;

public class StringUtils {

    public static String likeLower(String param) {
        return "%" + param.toLowerCase() + "%";
    }

    public static String like(String param) {
        return "%" + param + "%";
    }
}