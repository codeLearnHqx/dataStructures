package 链表.单向链表;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @Description
 * @Create by hqx
 * @Date 2023/11/21 14:17
 */
public class SinglyLinkedListSentinelTest {

    @Test
    void test01() {
        SinglyLinkedListSentinel listSentinel = new SinglyLinkedListSentinel();
        listSentinel.addLast(1);
        listSentinel.addLast(2);
        listSentinel.addLast(3);
        listSentinel.addLast(4);
        // 测试添加组后一个节点
        Assertions.assertIterableEquals(Arrays.asList(1, 2, 3, 4), listSentinel);
        listSentinel.loop1(System.out::println);
        listSentinel.loop2(System.out::println);
        System.out.println("-------------------------");
        System.out.println(listSentinel.get(1));
    }

    @Test
    void test02() {
        SinglyLinkedListSentinel listSentinel = new SinglyLinkedListSentinel();
        listSentinel.addLast(1);
        listSentinel.addLast(2);
        listSentinel.addLast(3);
        listSentinel.addLast(4);
        // 测试向链表指定索引处添加节点
        listSentinel.insert(0,  9);
        listSentinel.insert(5,  10);

        listSentinel.loop1(System.out::println);
    }


    @Test
    void test03() {
        SinglyLinkedListSentinel listSentinel = new SinglyLinkedListSentinel();
        // 测试向链表头处添加节点
        listSentinel.addFirst(999);

        listSentinel.loop1(System.out::println);
    }

    @Test
    void test04() {
        SinglyLinkedListSentinel listSentinel = new SinglyLinkedListSentinel();
        listSentinel.addLast(1);
        listSentinel.addLast(2);
        listSentinel.addLast(3);
        listSentinel.addLast(4);
        // 测试删除索引处节点
        listSentinel.remove(0);
        listSentinel.removeFirst();
        listSentinel.removeFirst();
        listSentinel.removeFirst();
        listSentinel.removeFirst();
        //listSentinel.remove(10);

        listSentinel.loop1(System.out::println);
    }

}
