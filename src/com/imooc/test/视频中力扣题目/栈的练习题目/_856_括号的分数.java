package com.imooc.test.视频中力扣题目.栈的练习题目;

import java.util.Stack;
/**
 * 示例 1：
 *
 * 输入： "()"
 * 输出： 1
 * 示例 2：
 *
 * 输入： "(())"
 * 输出： 2
 * 示例3：
 *
 * 输入： "()()"
 * 输出： 2
 * 示例4：
 *
 * 输入： "(()(()))"
 * 输出： 6
 *
 * 链接：https://leetcode-cn.com/problems/score-of-parentheses
 */
public class _856_括号的分数 {
    public static int scoreOfParentheses(String S) {
        Stack<Integer> st=new Stack<>();

        for(char c:S.toCharArray()){
            if(c=='(') st.push(0);  //遇到左括号入栈，用0模拟
            else {  //遇到右括号进行判断
                if(st.peek()==0){    //栈顶为0即栈顶为左括号，此时为()的情况，得1分
                    st.pop();
                    st.push(1);
                }else{  //栈顶不为左括号即为(ABC)的情况，得分为(A+B+C)*2
                    int t=0;
                    while(!st.empty() && st.peek()!=0){
                        t += st.peek();
                        st.pop();
                    }
                    st.pop();
                    st.push(t*2);
                }
            }
        }
        int sum=0;
        while(!st.empty()){ //最后栈内都是分数，没有括号了，求和即可
            sum += st.peek();
            st.pop();
        }
        return sum;
    }

    public static void main(String[] args) {
        String str = "()()";
        System.out.println(scoreOfParentheses(str));
    }
}
