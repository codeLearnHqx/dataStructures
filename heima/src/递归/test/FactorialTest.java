package 递归.test;

import org.junit.jupiter.api.Test;
import 递归.Factorial;

/**
 * @Description
 * @Create by hqx
 * @Date 2023/11/22 12:36
 */
public class FactorialTest {

    @Test
    void test() {
        Factorial factorial = new Factorial();
        int result = factorial.f(5);
        System.out.println(result); // 5 * 4 * 3 * 2 * 1 == 120
    }
}
