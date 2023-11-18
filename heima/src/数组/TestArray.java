package 数组;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @Description
 * @Create by hqx
 * @Date 2023/11/18 19:14
 */
public class TestArray {

    @Test
    public void testDynamicArray1() {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);

        dynamicArray.add(2, 5);


        // 普通for遍历
        for (int i = 0; i < 5; i++) {
            System.out.println(dynamicArray.get(i));
        }

    }

    @Test
    public void testDynamicArray2() {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);

        dynamicArray.add(2, 5);
        // 打印数组中的所有元素通过consumer函数式接口遍历
        dynamicArray.foreach(System.out::println);
    }

    @Test
    public void testDynamicArray3() {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);

        dynamicArray.add(2, 5);
        // 通过在迭代器使用增强for循环
        for (Integer element : dynamicArray) {
            System.out.println(element);
        }
    }

    @Test
    public void testDynamicArray4() {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);

        dynamicArray.add(2, 5);
        // 通过stream流来遍历
        dynamicArray.stream().forEach(System.out::println);
    }

    @Test
    public void testDynamicArray5() {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);
        dynamicArray.addLast(5);

        // 删除元素
        int remove = dynamicArray.remove(4);
        // 断言测试
        Assertions.assertEquals(5, remove);
        Assertions.assertIterableEquals(Arrays.asList(1, 2, 3, 4), dynamicArray);
    }

    @Test
    public void testDynamicArray6() {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);
        dynamicArray.addLast(5);
        dynamicArray.addLast(6);
        dynamicArray.addLast(7);
        dynamicArray.addLast(8);
        dynamicArray.addLast(9);

        // 扩容测试结果
        Assertions.assertIterableEquals(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9),
                dynamicArray);

    }

}
