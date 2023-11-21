package 链表.双向链表;

import org.junit.jupiter.api.Test;

/**
 * @Description
 * @Create by hqx
 * @Date 2023/11/21 15:44
 */
public class DoublyLinkedListSentinelTest {


    @Test
    void test01() {
        // 测试指定索引插入
        DoublyLinkedListSentinel dlls = new DoublyLinkedListSentinel();
        dlls.insert(0, 1);
        dlls.insert(1, 2);
        dlls.insert(2, 3);
        dlls.insert(0, 4);

        dlls.forEach(System.out::println);

    }

    @Test
    void test02() {
        // 测试移除索引处节点
        DoublyLinkedListSentinel dlls = new DoublyLinkedListSentinel();
        dlls.insert(0, 1);
        dlls.insert(1, 2);
        dlls.insert(2, 3);
        dlls.insert(0, 4);

        dlls.remove(4);
        dlls.forEach(System.out::println);

    }

    @Test
    void test03() {
        // 测试添加头点
        DoublyLinkedListSentinel dlls = new DoublyLinkedListSentinel();
        dlls.addFirst(4);
        dlls.addFirst(3);
        dlls.addFirst(2);
        dlls.addFirst(1);
        // 测试移除头节点
        dlls.removeFirst();
        dlls.forEach(System.out::println);

    }

    @Test
    void test04() {
        DoublyLinkedListSentinel dlls = new DoublyLinkedListSentinel();
        // 测试添加尾部节点
        dlls.addLast(1);
        dlls.addLast(2);
        dlls.addLast(3);
        dlls.addLast(4);
        // 测试移除尾部节点
        dlls.removeLast();
        dlls.removeLast();
        dlls.removeLast();
        dlls.forEach(System.out::println);
    }



}
