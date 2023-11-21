package 链表.环形链表;

import java.util.Iterator;

/**
 * @Description 双向环形链表（带哨兵）
 * @Create by hqx
 * @Date 2023/11/21 16:30
 */
public class DoublyCirCleLinkedListSentinel implements Iterable<Integer>{

    /**
     * 节点类
     */
    private static class Node {
        Node pre;
        int value;
        Node next;

        public Node(Node pre, int value, Node next) {
            this.pre = pre;
            this.value = value;
            this.next = next;
        }
    }

    private Node sentinel = new Node(null, -1, null); // 哨兵

    public DoublyCirCleLinkedListSentinel() {
        // 初始化哨兵，指向自己
        sentinel.pre = sentinel;
        sentinel.next = sentinel;
    }


    /**
     * 添加到第一个
     * @param value 待添加值
     */
    public void addFirst(int value) {
        Node a = sentinel;
        Node b = sentinel.next;
        Node added = new Node(a, value, b);
        a.next = added;
        b.pre = added;
    }

    /**
     * 添加到最后一个
     * @param value 待添加值
     */
    public void addLast(int value) {
        Node a = sentinel.pre;
        Node b = sentinel;
        Node added = new Node(a, value, b);
        a.next = added;
        b.pre = added;
    }

    /**
     * 删除第一个
     */
    public void removeFirst() {
        Node removed = sentinel.next;
        if (removed == sentinel) { // 只有哨兵时
            throw new IllegalArgumentException("链表为空");
        }
        Node a = sentinel;
        Node b = removed.next;
        a.next = b;
        b.pre = a;

    }

    /**
     * 删除最后一个
     */
    public void removeLast() {
        Node removed = sentinel.pre;
        if (removed == sentinel) { // 只有哨兵时
            throw new IllegalArgumentException("链表为空");
        }
        Node a = removed.pre;
        Node b = sentinel;

        a.next = b;
        b.pre = a;

    }

    /**
     * 根据值删除
     * @param value 待删除节点的值
     */
    public void removeByValue(int value) {
        Node removed = findByValue(value);
        if (removed == null) {
            return;
        }
        Node a = removed.pre;
        Node b = removed.next;

        a.next = b;
        b.pre = a;

    }

    /**
     * 根据值查找节点
     * @param value 值
     * @return
     */
    private Node findByValue(int value) {
        Node p = sentinel.next;
        while (p != sentinel) {
            if (p.value == value) {
                return p;
            }
            p = p.next;
        }
        return null;
    }




    /**
     * 用于迭代器遍历
     * @return
     */
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node p = sentinel.next;
            @Override
            public boolean hasNext() {
                return p != sentinel;
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
