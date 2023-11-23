package 递归.test;

import org.junit.jupiter.api.Test;
import 递归.InsertionSort;

import java.util.Arrays;

/**
 * @Description
 * @Create by hqx
 * @Date 2023/11/22 14:41
 */
public class InsertionSortTest {

    @Test
    void test() {
        int[] a = {53, 21, 13, 44, 44, 44, 33, 52, 7};
        InsertionSort.sort(a);
        System.out.println(Arrays.toString(a));
    }

}
