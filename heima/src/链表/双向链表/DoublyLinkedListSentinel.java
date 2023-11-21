package 链表.双向链表;

import java.util.Iterator;

/**
 * @Description 双向链表（带哨兵）
 * @Create by hqx
 * @Date 2023/11/21 15:27
 */
public class DoublyLinkedListSentinel implements Iterable<Integer>{
    /**
     * 节点类
     */
    static class Node {
        Node prev; // 上一个节点指针
        int value; // 值
        Node next; // 下一个节点指针

        public Node(Node prev, int value, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }

    private Node head; // 头哨兵
    private Node tail;// 尾哨兵

    public DoublyLinkedListSentinel() {
        head = new Node(null, 666, null);
        tail = new Node(null, 888, null);
        head.next = tail;
        tail.prev = head;
    }

    /**
     * 查找指定索引处的节点
     * @param index 索引
     */
    private Node findNode(int index) {
        int i = -1;
        for (Node p = head; p != tail; p = p.next, i++) {
            if (i == index) {
                return p;
            }
        }
        return null;
    }

    /**
     * 链表头部添加节点
     * @param value 值
     */
    public void addFirst(int value) {
        insert(0, value);
    }

    /**
     * 移除链表头节点
     */
    public void removeFirst() {
        remove(0);
    }

    /**
     * 链表尾添加节点
     * @param value 值
     */
    public void addLast(int value) {
        Node last = tail.prev; // 尾部节点
        Node added = new Node(last, value, tail);
        last.next = added;
        tail.prev = added;
    }

    /**
     * 移除链表尾部节点
     */
    public void removeLast() {
        Node last = tail.prev; // 尾部节点
        if (last == head) {
            throw illegalIndex(0);
        }
        Node prev = last.prev;
        prev.next = tail;
        tail.prev = prev;
    }


    /**
     * 向索引处插入节点
     * @param index 索引
     * @param value 值
     */
    public void insert(int index, int value) {
        Node preNode = findNode(index - 1); // 待插入位置的上一个节点
        if (preNode == null) { // 索引错误
            throw illegalIndex(index);
        }
        Node nextNode = preNode.next;
        Node insertedNode = new Node(preNode, value, nextNode);
        preNode.next = insertedNode;
        nextNode.prev = insertedNode;
    }


    /**
     * 删除索引处节点
     * @param index 索引
     */
    public void remove(int index) {
        Node pre = findNode(index - 1); // 待删除节点的上一个节点、
        if (pre == null) {
            throw illegalIndex(index);
        }
        Node removed = pre.next; // 待删除节点
        if (removed == tail) { // 删除节点为尾哨兵时
            throw illegalIndex(index);
        }
        Node next = removed.next; // 待删除节点的下一个节点

        pre.next = next;
        next.prev = pre;
    }



    private static IllegalArgumentException illegalIndex(int index) {
        return new IllegalArgumentException(String.format("index [%d] 不合法\n", index));
    }


    /**
     * 迭代器遍历
     */
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node p = head.next;
            @Override
            public boolean hasNext() {
                return p != tail;
            }

            @Override
            public Integer next() {
                int val = p.value;
                p = p.next;
                return val;
            }
        };
    }

}
