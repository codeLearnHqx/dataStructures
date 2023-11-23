package 递归.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import 递归.BinarySearch;

/**
 * @Description
 * @Create by hqx
 * @Date 2023/11/22 13:54
 */
public class BinarySearchTest {


    @Test
    void test() {
        int[] a = {7, 13, 21, 30, 44, 52, 53};
        Assertions.assertEquals(0, BinarySearch.search(a, 7));
        Assertions.assertEquals(6, BinarySearch.search(a, 53));
        Assertions.assertEquals(3, BinarySearch.search(a, 30));
        Assertions.assertEquals(1, BinarySearch.search(a, 13));
        Assertions.assertEquals(5, BinarySearch.search(a, 52));
    }

}
