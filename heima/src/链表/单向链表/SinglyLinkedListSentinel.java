package 链表.单向链表;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * @Description 单向链表实现（带哨兵）
 * @Create by hqx
 * @Date 2023/11/19 19:58
 */
public class SinglyLinkedListSentinel implements Iterable<Integer>{
    private Node head = new Node(0, null); // 哨兵


    /**
     * 节点类
     */
    private static class Node {
        int value; // 值
        Node next; // 下一个节点指针

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }


    /**
     * 向链表头部添加
     * @param value 待添加值
     */
    public void addFirst(int value) {
        insert(0, value);
    }


    /**
     * 找到链表最后的节点
     * @return 链表最后的节点
     */
    private Node findLast() {
        Node p;
        for (p = head; p.next != null; p = p.next) {}
        return p;
    }

    /**
     * 将节点添加至链表的最后
     * @param value 待添加值
     */
    public void addLast(int value) {
        Node last = findLast();
        last.next = new Node(value, null);
    }

    /**
     * 通过索引查找节点
     * @param index 索引
     * @return 指定索引对应的节点，未找到返回null
     */
    private Node findNode(int index) {
        int i = -1;
        for (Node p = head; p != null; p = p.next, i++) {
            if (index == i) {
                return p;
            }
        }
        return null; // 未找到
    }

    private static IllegalArgumentException illegalIndex(int index) {
        return new IllegalArgumentException(String.format("index [%d] 不合法\n", index));
    }


    /**
     * 根据索引来查找节点值
     * @param index 查找的索引
     * @return 索引对应的节点值
     */
    public int get(int index) {
        Node node = findNode(index);
        if (node == null) {
            throw illegalIndex(index);
        }
        return node.value;
    }


    /**
     * 向索引位置插入
     * @param index 索引
     * @param value 待插入值
     * @Throws IllegalArgumentException 找不到，抛出异常
     */
    public void insert(int index, int value) {
        Node preNode = findNode(index - 1);
        if (preNode == null) {
            throw illegalIndex(index);
        }
        preNode.next = new Node(value, preNode.next);

    }


    /**
     * 删除链表头部节点
     */
    public void removeFirst() {
        remove(0);
    }


    /**
     *  从索引位置删除
     * @param index 索引
     */
    public void remove(int index) {
        Node preNode = findNode(index - 1); // 上一个节点
        if (preNode == null) {
            throw illegalIndex(index);
        }
        Node removed = preNode.next; // 被删除节点
        if (removed == null) {
            throw illegalIndex(index);
        }
        preNode.next = removed.next;

    }



    /**
     * 遍历链表（while）
     * @param consumer 消费型函数式接口
     */
    public void loop1(Consumer<Integer> consumer) {
        Node p = head.next;
        while (p != null) {
            consumer.accept(p.value);
            p = p.next;
        }
    }

    /**
     * 遍历链表（for）
     * @param consumer 消费型函数式接口
     */
    public void loop2(Consumer<Integer> consumer) {
        for (Node p = head.next; p != null; p = p.next) {
            consumer.accept(p.value);
        }
    }

    /**
     * 使用迭代器遍历链表
     */
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node p = head.next;
            @Override
            public boolean hasNext() {  // 是否有下一个元素
                return p != null;
            }

            @Override
            public Integer next() { // 返回当前值，并指向下一个元素
                int value = p.value;
                p = p.next;
                return value;
            }
        };
    }

}
