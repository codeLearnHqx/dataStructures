package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description
 * @Create by hqx
 * @Date 2023/10/26 12:50
 */
public class Test01 {


    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode1;

        Solution solution = new Solution();
        boolean result = solution.hasCycle(listNode1);
        System.out.println(result);

    }



}

class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        Set<ListNode> dataSet = new HashSet<>();
        ListNode temp = head;
        while(true) {
            if (temp.next == null) {
                return false;
            }
            if (dataSet.contains(temp.next)) {
                return true;
            }
            dataSet.add(temp);
            temp = temp.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
