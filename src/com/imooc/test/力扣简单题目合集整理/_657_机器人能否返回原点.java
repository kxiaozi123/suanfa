package com.imooc.test.力扣简单题目合集整理;

/**
 * 示例 1:
 *
 * 输入: "UD"
 * 输出: true
 * 解释：机器人向上移动一次，然后向下移动一次。所有动作都具有相同的幅度，因此它最终回到它开始的原点。因此，我们返回 true。
 * 示例 2:
 *
 * 输入: "LL"
 * 输出: false
 * 解释：机器人向左移动两次。它最终位于原点的左侧，距原点有两次 “移动” 的距离。我们返回 false，因为它在移动结束时没有返回原点。
 *
 * 链接：https://leetcode-cn.com/problems/robot-return-to-origin
 */
public class _657_机器人能否返回原点 {
    public boolean judgeCircle(String moves) {
        int x=0;
        int y=0;
        char[] chars = moves.toCharArray();
        for (char aChar : chars) {
            if(aChar=='U') y++;
            else if(aChar=='D') y--;
            else if(aChar=='L') x--;
            else if (aChar=='R') x++;
        }
        return x==0&&y==0;
    }
    public static void main(String[] args) {

    }

}
