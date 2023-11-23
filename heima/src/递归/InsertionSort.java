package 递归;

/**
 * @Description 插入排序
 * @Create by hqx
 * @Date 2023/11/22 14:25
 */
public class InsertionSort {

    public static void sort(int[] a) {
        insertion(a, 1); // 默认第一个数是已经排好序的
    }

    public static void insertion(int[] a, int low) {
        if (low == a.length) return;

        int temp = a[low]; // 未排序区域开始指针
        int i = low - 1; // 已排序区域结尾指针

        while (i >= 0 && a[i] > temp) { // 没有找到插入位置
            a[i + 1] = a[i]; // 空出插入位置
            i--;
        }
        // 找到插入位置
        if (i + 1 != low) {
            a[i + 1] = temp;
        }

        insertion(a, low + 1);
    }

}
