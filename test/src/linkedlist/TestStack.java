package linkedlist;

import java.util.Stack;

/**
 * @Create by hqx
 * @Date 2023/10/19 16:28
 * @Description
 * 演示栈的基本使用
 */
public class TestStack {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        // 入栈
        stack.add("jack");
        stack.add("tom");
        stack.add("smith");

        // 出栈
        while (stack.size() > 0) {
            System.out.println(stack.pop()); // pop将栈顶的数据取出
        }
    }
}
