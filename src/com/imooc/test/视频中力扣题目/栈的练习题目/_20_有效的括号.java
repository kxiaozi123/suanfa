package com.imooc.test.视频中力扣题目.栈的练习题目;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例5:
 *
 * 输入: "{[]}"
 * 输出: true
 *
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 */
public class _20_有效的括号 {
    public static Map<Character, Character> map = new HashMap<>();

    static {
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
    }

    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            if (map.containsKey(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;

                if (c != map.get(stack.pop())) return false;
            }
        }
        return stack.isEmpty();

    }
    //网友的写法
    public boolean isValid2(String s) {
        if(s.isEmpty()) return true;
        Stack<Character> stack = new Stack<>();
        for(char c:s.toCharArray()){
            if(c=='(') stack.push(')');
            else if (c=='{') stack.push('}');
            else if (c=='[') stack.push(']');
            else if (stack.isEmpty()||c!=stack.pop())
            {return false;}
        }


        return stack.isEmpty();

    }

    public static void main(String[] args) {

    }
}
