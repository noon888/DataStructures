package com.atguigu.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: Administrator
 * @DATE:2020/5/21 12:54
 */
public class PolandNotation1 {
    private static final String SYMBOL = "[+\\-*/()]";
    private static final String LEFT = "(";
    private static final String RIGHT = ")";
    private static final Stack<String> stack = new Stack<>();
    private static final List<String> list = new ArrayList<>();
    public static void main(String[] args) {
        String str = "12.8 + (2 - 3.55)*4+10/5.0";
//        String str = "(3+4)*5-6";
        System.out.println(suffixList(str));
        double d = calc(suffixList(str));
        System.out.println(d);
    }

    /**
     * 将逆波兰list放入栈，算出结果
     * @param suffixList  逆波兰形式的list
     */
    private static double calc(List<String> suffixList) {
        Stack<String> stack = new Stack<>();
        double num1, num2, result;
        for (String item : suffixList) {
            if (isSymbol(item)) {
                num1 = Double.parseDouble(stack.pop());
                num2 = Double.parseDouble(stack.pop());
                switch (item) {
                    case "+":
                        result = num2 + num1;
                        break;
                    case "-":
                        result = num2 - num1;
                        break;
                    case "*":
                        result = num2 * num1;
                        break;
                    case "/":
                        result = num2 / num1;
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + item);
                }
                stack.push(String.valueOf(result));
            }else {
                stack.push(item);
            }
        }
        return Double.parseDouble(stack.pop());
    }

    /**
     * 中缀表达式字符串转逆波兰list
     * @param str  中缀表达式字符串
     */
    private static List<String> suffixList(String str) {
        String temp;
        int start = 0;
        String suffixString = removeBlank(str);
        for (int i=0; i<suffixString.length(); i++) {
            if (isSymbol(suffixString.charAt(i) + "")) {
                temp = suffixString.charAt(i) + "";
                if (stack.isEmpty() || LEFT.equals(temp) || priority(temp) > priority(stack.peek())) {
                    stack.push(temp);
                }else if(RIGHT.equals(temp)) {
                    while(!LEFT.equals(stack.peek())) {
                        list.add(stack.pop());
                    }
                    stack.pop();
                }else if(priority(temp) <= priority(stack.peek())) {
                    while(!stack.isEmpty() && !LEFT.equals(stack.peek()) && priority(temp) <= priority(stack.peek())) {
                        list.add(stack.pop());
                    }
                    stack.push(temp);
                }
                start = i + 1;
            }else if(i == suffixString.length() - 1 || isSymbol(suffixString.charAt(i + 1) + "")){
                temp = start == 0 ? suffixString.substring(0, i + 1) : suffixString.substring(start, i + 1);
                list.add(temp);
            }
        }
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;
    }

    private static int priority(String s) {
        if("+".equals(s) || "-".equals(s)) {
            return 1;
        }
        if ("*".equals(s) || "/".equals(s)) {
            return 2;
        }
        return 0;
    }

    private static boolean isSymbol(String s) {
        return s.matches(SYMBOL);
    }

    private static String removeBlank(String str) {
        return str.replaceAll("\\s+", "");
    }
}
