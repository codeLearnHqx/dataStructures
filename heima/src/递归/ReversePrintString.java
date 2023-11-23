package 递归;

/**
 * @Description 反向打印字符串
 * @Create by hqx
 * @Date 2023/11/22 13:33
 */
public class ReversePrintString {

    public static void reversePrint(int n, String str) {
        if (n == str.length()) return;
        reversePrint(n + 1, str);
        System.out.print(str.charAt(n));
    }

    public static void main(String[] args) {
        reversePrint(0, "huang");
    }


}
