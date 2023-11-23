package 递归;

/**
 * @Description 递归求斐波那契数列
 * @Create by hqx
 * @Date 2023/11/23 10:21
 */
public class Fibonacci {

    public static int fn(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fn(n -1) + fn(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(fn(10));
    }

}
