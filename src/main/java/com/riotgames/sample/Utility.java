package com.riotgames.sample;

import java.util.regex.Pattern;

/**
 * Created by KimDongha on 2017-04-03.
 */
public class Utility {

    public static boolean isNumber(String s) {
        String numRegex = "\\d+(\\.\\d*)?|\\.\\d+";
        Pattern p = Pattern.compile(numRegex);
        return p.matcher(s).matches();
    }

    public static boolean isOperator(String s) {
        if ("+".equals(s) || "*".equals(s) || "/".equals(s) || "-".equals(s) || "(".equals(s) || ")".equals(s)) {
            return true;
        }
        return false;
    }

    public static boolean isHigherPrirorty(String op1, String op2) {

        if ("+".equals(op1) || "-".equals(op1)) {
            if ("/".equals(op2) || "*".equals(op2)) {
                return false;
            }
            return true;
        }

        if ("*".equals(op1) || "/".equals(op1)) {
            if ("+".equals(op2) || "-".equals(op2)) {
                return true;
            }
            return false;
        }
        return false;
    }

    private Utility() {

    }
}
