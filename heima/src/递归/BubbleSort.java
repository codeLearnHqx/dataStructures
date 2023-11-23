package 递归;


/**
 * @Description 递归冒泡排序
 * @Create by hqx
 * @Date 2023/11/22 13:58
 */
public class BubbleSort {

    public static void sort(int[] a) {
        bubble(a, a.length - 1);
    }

    /**
     * 递归函数
     * @param a 排序数组
     * @param j 未排序的区域边界
     */
    private static void bubble(int[] a, int j) {
        if (j == 0) {
            return;
        }
        int x = 0; // 有序和无序的分界点
        for (int i = 0; i < j; i++) {
            if (a[i] > a[i + 1]) {
                int temp = a[i];
                a[i] = a[i + 1];
                a[i + 1] = temp;
                x = i;
            }
        }
        bubble(a, x);
    }


}
