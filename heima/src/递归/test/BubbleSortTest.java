package 递归.test;

import org.junit.jupiter.api.Test;
import 递归.BubbleSort;

import java.util.Arrays;

/**
 * @Description
 * @Create by hqx
 * @Date 2023/11/22 14:13
 */
public class BubbleSortTest {

    @Test
    void test() {
        int[] a = {6, 5, 7, 2, 1};
        BubbleSort.sort(a);
        System.out.println(Arrays.toString(a));
    }

}
