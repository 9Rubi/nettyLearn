package com.nine.netty.asd;

/**
 * 百度文库 处理
 * @author : Rubi
 * @version : 2018-12-27 10:22
 */
public class AS {
    public static void main(String[] args) {
        String source = "";
        StringBuffer target = new StringBuffer();
        boolean isReadingChinese = false;
        int begin = 0;
        int end = 0;
        for (int index = 0; index < source.length() - 1; index++) {
            char ch = source.charAt(index);
            if (isChinese(ch)) {
                if (!isReadingChinese) {
                    begin = index;
                }
                isReadingChinese = true;
            } else {
                if (isReadingChinese) {
                    end = index;
                }
                isReadingChinese = false;
            }
            if (end != 0 && begin != 0) {
                String part = source.substring(begin, end);
                if (part != " "&&part!= "") {
                    target.append(part);
                }
                end = 0;
                begin = 0;
            }
        }

        System.out.println(target);


    }


    public static boolean isChinese(String strName) {
        char[] ch = strName.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            char c = ch[i];
            if (isChinese(c)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isChinese(char c) {
        if (c == '\n') {
            return true;
        }
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
            return true;
        }
        return false;
    }
}
