package com.imooc.test.视频中力扣题目.栈的练习题目;

import java.util.Stack;

/**
 * 示例1：
 *
 * 输入: ["2", "1", "+", "3", "*"]
 * 输出: 9
 * 解释: 该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
 * 示例2：
 *
 * 输入: ["4", "13", "5", "/", "+"]
 * 输出: 6
 * 解释: 该算式转化为常见的中缀算术表达式为：(4 + (13 / 5)) = 6
 * 示例3：
 *
 * 输入: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
 * 输出: 22
 * 解释:
 * 该算式转化为常见的中缀算术表达式为：
 *   ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 *
 * 链接：https://leetcode-cn.com/problems/evaluate-reverse-polish-notation
 */
public class _150_逆波兰表达式求值 {
    // 栈实现   8 ms	36.7 MB
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack=new Stack<>();
        Integer op1,op2;
        for (String s : tokens) {
            switch (s){
                case "+":
                    op2=stack.pop();
                    op1=stack.pop();
                    stack.push(op1+op2);
                    break;
                case "-":
                    op2=stack.pop();
                    op1=stack.pop();
                    stack.push(op1-op2);
                    break;
                case "*":
                    op2=stack.pop();
                    op1=stack.pop();
                    stack.push(op1*op2);
                    break;
                case "/":
                    op2=stack.pop();
                    op1=stack.pop();
                    stack.push(op1/op2);
                    break;
                default:
                    stack.push(Integer.valueOf(s));
                    break;
            }
        }
        return stack.pop();
    }

    public static int evalRPN2(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String str : tokens) {
            if (isOp(str)) {
                int ret = doOp(stack.pop(), stack.pop(), str);
                stack.push(ret);
            } else {
                stack.push(Integer.valueOf(str));
            }
        }
        return stack.pop();
    }

    private static int doOp(Integer pop1, Integer pop, String str) {
        switch (str) {
            case "+":
                return pop + pop1;
            case "-":
                return pop - pop1;
            case "*":
                return pop * pop1;
            case "/":
                return pop / pop1;
        }
        return 0;
    }

    private static boolean isOp(String str) {
        return str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/");
    }

    public static void main(String[] args) {
        String[] tokens=new String[]{ "2", "1", "+", "3", "*"};
        System.out.println(evalRPN2(tokens));
    }
}
