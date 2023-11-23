package 递归;

/**
 * @Description 递归二分查找
 * @Create by hqx
 * @Date 2023/11/22 13:44
 */
public class BinarySearch {

    public static int search(int[] a, int target) {
        return f(a, target, 0, a.length -1);
    }

    /**
     * 递归
     * @param a 数组
     * @param target 目标值
     * @param i 起始索引（包含）
     * @param j 结束索引（包含）
     * @return 找到返回索引，找不到返回-1
     */
    private static int f(int[] a, int target, int i, int j) {
        if (i > j) {
            return -1;
        }
        int m = (i + j) >>> 1;
        if (target < a[m]) {
            return f(a, target, i, m -1);
        } else if (a[m] < target) {
            return f(a, target, m + 1, j);
        } else {
            return m;
        }
    }


}
