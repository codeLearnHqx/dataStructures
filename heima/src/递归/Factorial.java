package 递归;

/**
 * @Description 求阶乘  5 * 4 * 3 * 2 * 1
 * @Create by hqx
 * @Date 2023/11/22 12:34
 */
public class Factorial {
    /**
     * 求指定数的阶乘
     * @param n 数值
     * @return n的阶乘
     */
    public int f(int n) {
        if (n == 1) {
            return 1;
        }
        return n * f(n -1);
    }

}
