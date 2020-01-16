package com.xhk.practice.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * 随机码生成工具
 *
 * @author liuhai
 */
public class RandomCodeGeneratorUtils {

    /**
     * 随机码类型枚举
     *
     * @author liuhai
     */
    public static enum TYPE {
        /**
         * 字符型
         */
        LETTER,
        /**
         * 大写字符型
         */
        CAPITAL,
        /**
         * 数字型
         */
        NUMBER,
        /**
         * 符号型
         */
        SIGN,
        /**
         * 大+小字符 型
         */
        LETTER_CAPITAL,
        /**
         * 小字符+数字 型
         */
        LETTER_NUMBER,
        /**
         * 大+小字符+数字 型
         */
        LETTER_CAPITAL_NUMBER,
        /**
         * 大+小字符+数字+符号 型
         */
        LETTER_CAPITAL_NUMBER_SIGN
    }

    /**
     * 小写字母列表
     */
    private static final String[] LOWERCASE = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n",
            "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    /**
     * 大写字母列表
     */
    private static final String[] CAPITAL = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O",
            "P", "Q", "BLogic", "S", "T", "U", "V", "W", "X", "Y", "Z"};

    /**
     * 数字列表
     */
    private static final String[] NUMBER = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};

    /**
     * 符号列表
     */
    private static final String[] SIGN = {"~", "!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "_", "+", "`", "-",
            "=", "{", "}", "|", ":", "\"", "<", ">", "?", "[", "]", "\\", ";", "'", ",", ".", "/"};

    /**
     * 静态随机数
     */
    private static Random random = new Random();

    /**
     * 获取随机组合码
     *
     * @param length 位数
     * @param type   类型
     *               字符型 LETTER, <br>
     *               大写字符型 CAPITAL, <br>
     *               数字型 NUMBER, <br>
     *               符号型 SIGN, <br>
     *               大+小字符型 LETTER_CAPITAL, <br>
     *               小字符+数字 型 LETTER_NUMBER, <br>
     *               大+小字符+数字 型 LETTER_CAPITAL_NUMBER, <br>
     *               大+小字符+数字+符号 型 LETTER_CAPITAL_NUMBER_SIGN
     */
    public static String getRandomCode(int length, TYPE type) {
        ArrayList<String> temp = new ArrayList<>();
        StringBuilder code = new StringBuilder();
        if (type == TYPE.LETTER) {
            temp.addAll(Arrays.asList(LOWERCASE));
        } else if (type == TYPE.CAPITAL) {
            temp.addAll(Arrays.asList(CAPITAL));
        } else if (type == TYPE.NUMBER) {
            temp.addAll(Arrays.asList(NUMBER));
        } else if (type == TYPE.SIGN) {
            temp.addAll(Arrays.asList(SIGN));
        } else if (type == TYPE.LETTER_CAPITAL) {
            temp.addAll(Arrays.asList(LOWERCASE));
            temp.addAll(Arrays.asList(CAPITAL));
        } else if (type == TYPE.LETTER_NUMBER) {
            temp.addAll(Arrays.asList(LOWERCASE));
            temp.addAll(Arrays.asList(NUMBER));
        } else if (type == TYPE.LETTER_CAPITAL_NUMBER) {
            temp.addAll(Arrays.asList(LOWERCASE));
            temp.addAll(Arrays.asList(CAPITAL));
            temp.addAll(Arrays.asList(NUMBER));
        } else if (type == TYPE.LETTER_CAPITAL_NUMBER_SIGN) {
            temp.addAll(Arrays.asList(LOWERCASE));
            temp.addAll(Arrays.asList(CAPITAL));
            temp.addAll(Arrays.asList(NUMBER));
            temp.addAll(Arrays.asList(SIGN));
        }
        for (int i = 0; i < length; i++) {
            int rint = random.nextInt(temp.size());
            String tStr = temp.get(rint);
            code.append(tStr);
        }
        return code.toString();
    }


}
