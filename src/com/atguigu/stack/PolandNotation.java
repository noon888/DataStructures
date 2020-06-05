package com.atguigu.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: Administrator
 * @DATE:2020/5/17 22:04
 */
public class PolandNotation {
    private static final String SYMBOL = "[+\\-*/()]";
    private static final String NUMBER = "^[-+]?[.\\d]*$";
    private static final int LEVER_1 = 1;
    private static final int LEVER_2 = 2;
    private static final String LEFT = "(";
    private static final String RIGHT = ")";
    private static final Stack<String> stack = new Stack<String>();
    private static final List<String> suffixList = new ArrayList<>();
    public static void main(String[] args) {
        String str = "12.8 + (2 - 3.55)*4+10/5.0";
//        String str = "(3+4)*5-6";
        // 转后缀表达式list
        try {
            List<String> suffixExpressionList = toMatch(str);
            System.out.println(suffixExpressionList);
            double d = doCalc(suffixExpressionList);
            System.out.println(d);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static double doCalc(List<String> suffixExpressionList) {
        Stack<String> stack = new Stack<>();
        double num1, num2, result;
        for (String item : suffixExpressionList) {
            if (isSymbol(item)) {
                num1 = Double.parseDouble(stack.pop());
                num2 = Double.parseDouble(stack.pop());
                switch (item) {
                    case "+":
                        result =  num1 + num2;
                        break;
                    case "-":
                        result = num2 - num1;
                        break;
                    case "*":
                        result = num1 * num2;
                        break;
                    case "/":
                        result = num2 / num1;
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + item);
                }
                stack.push(String.valueOf(result));
            }else if(isNumber(item)) {
                stack.push(item);
            }
        }
        return Double.parseDouble(stack.pop());
    }

    /**
     * 字符串转后缀list
     */
    private static List<String> toMatch(String str) throws Exception {
        int start = 0;
        String temp = "";
        if (str.length() == 0) {
            throw new Exception("data is empty");
        }
        String infixExpression = removeSpace(str);
        for (int i=0; i<infixExpression.length(); i++) {
            if (isSymbol(infixExpression.charAt(i) + "")) {
                String s = infixExpression.charAt(i) + "";
                if (stack.empty() || priority(s) > priority(stack.peek()) || LEFT.equals(s)) {
                    stack.push(s);
                }else if(RIGHT.equals(s)) {
                    while(!LEFT.equals(stack.peek())) {
                        suffixList.add(stack.pop());
                    }
                    stack.pop();
                }else if(priority(s) <= priority(stack.peek())) {
                    while(!stack.empty() && !LEFT.equals(stack.peek()) && priority(s) <= priority(stack.peek())) {
                        suffixList.add(stack.pop());
                    }
                    stack.push(s);
                }
                start = i + 1;
            } else if(i == infixExpression.length() - 1 || isSymbol(infixExpression.charAt(i + 1) + "")) {
                temp = start == 0 ? infixExpression.substring(0, i+1) : infixExpression.substring(start, i+1);
                suffixList.add(temp);
            }
        }
        while (!stack.empty()) {
            suffixList.add(stack.pop());
        }
        return suffixList;
    }
    private static int priority(String s) {
        if ("+".equals(s) || "-".equals(s)) {
            return LEVER_1;
        }
        if ("*".equals(s) || "/".equals(s)) {
            return LEVER_2;
        }
        return -1;
    }
    private static boolean isNumber(String s) {
        return s.matches(NUMBER);
    }
    private static boolean isSymbol(String str) {
        return str.matches(SYMBOL);
    }
    private static String removeSpace(String infixExpression) {
        return infixExpression.replaceAll("\\s+", "");
    }
}
