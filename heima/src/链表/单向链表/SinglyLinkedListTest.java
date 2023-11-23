package 链表.单向链表;

import org.junit.jupiter.api.Test;

/**
 * @Description 测试类
 * @Create by hqx
 * @Date 2023/11/20 18:23
 */
public class SinglyLinkedListTest {

    @Test
    void test01() {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.addFirst(1);
        singlyLinkedList.addFirst(2);
        singlyLinkedList.addFirst(3);
        singlyLinkedList.addFirst(4);

        // while
        singlyLinkedList.loop1(v -> System.out.println(v));
    }

    @Test
    void test02() {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.addFirst(1);
        singlyLinkedList.addFirst(2);
        singlyLinkedList.addFirst(3);
        singlyLinkedList.addFirst(4);

        // for
        singlyLinkedList.loop2(v -> System.out.println(v));
    }

    @Test
    void test03() {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.addFirst(1);
        singlyLinkedList.addFirst(2);
        singlyLinkedList.addFirst(3);
        singlyLinkedList.addFirst(4);

        // 迭代器
        for (Integer value : singlyLinkedList) {
            System.out.println(value);
        }
    }


    @Test
    void test04() {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();

        singlyLinkedList.addLast(1);
        singlyLinkedList.addLast(2);
        singlyLinkedList.addLast(3);
        singlyLinkedList.addLast(4);

        for (Integer value : singlyLinkedList) {
            System.out.println(value);
        }
    }

    @Test
    void test05() {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();

        singlyLinkedList.addLast(1);
        singlyLinkedList.addLast(2);
        singlyLinkedList.addLast(3);
        singlyLinkedList.addLast(4);

        // 查找索引为2的元素
        System.out.println(singlyLinkedList.get(2));
    }

    @Test
    void test06() {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();

        singlyLinkedList.addLast(1);
        singlyLinkedList.addLast(2);
        singlyLinkedList.addLast(3);
        singlyLinkedList.addLast(4);

        // 指定位置插入节点
        singlyLinkedList.insert(4, 8);

        singlyLinkedList.forEach(System.out::println);
    }

    @Test
    void test07() {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();

        singlyLinkedList.addLast(1);
        singlyLinkedList.addLast(2);
        singlyLinkedList.addLast(3);
        singlyLinkedList.addLast(4);

        // 删除链表头部节点
        singlyLinkedList.removeFirst();

        singlyLinkedList.forEach(System.out::println);
    }

    @Test
    void test08() {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();

        singlyLinkedList.addLast(1);
        singlyLinkedList.addLast(2);
        singlyLinkedList.addLast(3);
        singlyLinkedList.addLast(4);

        // 删除链表指定索引节点
        singlyLinkedList.remove(2);

        singlyLinkedList.forEach(System.out::println);
    }

    @Test
    void test09() {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();

        singlyLinkedList.addLast(1);
        singlyLinkedList.addLast(2);
        singlyLinkedList.addLast(3);
        singlyLinkedList.addLast(4);

        // 使用递归遍历
        singlyLinkedList.loop3();
    }

}
