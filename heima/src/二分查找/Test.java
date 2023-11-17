package 二分查找;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @Description
 * @Create by hqx
 * @Date 2023/11/9 0:07
 */
public class Test {

    public static void main(String[] args) {
        HashSet<ListNode> nodes = new HashSet<>();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(1);
        nodes.add(node1);
        nodes.add(node2);
        nodes.add(node3);
        nodes.add(node4);
        nodes.add(node5);
        System.out.println(nodes.size());
        System.out.println(nodes.contains(node5));
        System.out.println(nodes.contains(node1));
    }

}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
