package com.imooc.test.力扣简单题目合集整理;

/**
 * https://leetcode-cn.com/problems/defanging-an-ip-address/
 * 输入：address = "1.1.1.1"
 * 输出："1[.]1[.]1[.]1"
 * 输入：address = "255.100.50.0"
 * 输出："255[.]100[.]50[.]0"
 */
public class _1108_IP_地址无效化 {
    public static String defangIPaddr(String address) {
        return address.replace(".","[.]");
    }
    public static void main(String[] args) {
        String address = "255.100.50.0";
        System.out.println(address.replace(".", "[.]"));
    }
}
