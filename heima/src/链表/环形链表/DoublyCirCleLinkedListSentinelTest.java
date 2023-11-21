package 链表.环形链表;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @Description
 * @Create by hqx
 * @Date 2023/11/21 16:41
 */
public class DoublyCirCleLinkedListSentinelTest {


    @Test
    void test01() {
        DoublyCirCleLinkedListSentinel cirCleLinkedListSentinel = new DoublyCirCleLinkedListSentinel();
        // 测试添加头部
        cirCleLinkedListSentinel.addFirst(1);
        cirCleLinkedListSentinel.addFirst(2);
        cirCleLinkedListSentinel.addFirst(3);
        cirCleLinkedListSentinel.addFirst(4);
        cirCleLinkedListSentinel.addFirst(5);

        // 遍历
        cirCleLinkedListSentinel.forEach(System.out::println);

    }

    @Test
    void test02() {
        DoublyCirCleLinkedListSentinel cirCleLinkedListSentinel = new DoublyCirCleLinkedListSentinel();
        cirCleLinkedListSentinel.addFirst(1);
        cirCleLinkedListSentinel.addFirst(2);
        // 测试添加尾部
        cirCleLinkedListSentinel.addLast(8);
        cirCleLinkedListSentinel.addLast(9);

        // 遍历
        cirCleLinkedListSentinel.forEach(System.out::println);

    }
    @Test
    void test03() {
        DoublyCirCleLinkedListSentinel cirCleLinkedListSentinel = new DoublyCirCleLinkedListSentinel();
        cirCleLinkedListSentinel.addLast(1);
        cirCleLinkedListSentinel.addLast(2);
        cirCleLinkedListSentinel.addLast(3);
        // 测试删除第一个节点
        cirCleLinkedListSentinel.removeFirst();
        cirCleLinkedListSentinel.removeFirst();

        // 遍历
        cirCleLinkedListSentinel.forEach(System.out::println);

    }


    @Test
    void test04() {
        DoublyCirCleLinkedListSentinel cirCleLinkedListSentinel = new DoublyCirCleLinkedListSentinel();
        cirCleLinkedListSentinel.addLast(1);
        cirCleLinkedListSentinel.addLast(2);
        cirCleLinkedListSentinel.addLast(3);
        // 测试删除最后一个节点
        cirCleLinkedListSentinel.removeLast();
        cirCleLinkedListSentinel.removeLast();
        //cirCleLinkedListSentinel.removeLast();
        //cirCleLinkedListSentinel.removeLast();
        // 遍历
        cirCleLinkedListSentinel.forEach(System.out::println);

    }


    @Test
    void test05() {
        DoublyCirCleLinkedListSentinel cirCleLinkedListSentinel = new DoublyCirCleLinkedListSentinel();
        cirCleLinkedListSentinel.addLast(1);
        cirCleLinkedListSentinel.addLast(2);
        cirCleLinkedListSentinel.addLast(3);
        cirCleLinkedListSentinel.addLast(8);
        // 测试根据值删除节点
        cirCleLinkedListSentinel.removeByValue(3);
        cirCleLinkedListSentinel.removeByValue(10);
        cirCleLinkedListSentinel.removeByValue(8);
        Assertions.assertIterableEquals(Arrays.asList(1, 2), cirCleLinkedListSentinel);
        // 遍历
        cirCleLinkedListSentinel.forEach(System.out::println);

    }




}
