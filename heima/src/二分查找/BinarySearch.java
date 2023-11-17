package 二分查找;

import java.util.Arrays;

/**
 * @Description
 * @Create by hqx
 * @Date 2023/11/7 20:38
 */
public class BinarySearch {


    public static void main(String[] args) {
        int[] a = {7, 13, 30, 30, 38, 44, 52};
        //System.out.println(binarySearchAlternative(a, 7));

        int result = binarySearchLeftmost1(a, 30);
        System.out.println(result);

    }



    /**
     * 二分查找基础版（因为int类型存在最大值限制，使用 (i + j) / 2 计算中间值时可能会超出最大值限制从而变成负数，所以使用无符号右移以为能避免这种结果(i + j) >>> 1）
     * @param a 待查找的升序数组
     * @param target 待查找的目标值
     * @return 找到返回索引，找不到返回-1
     */
    public static int binarySearchBasic(int[] a, int target) {
        int i = 0, j = a.length -1; // 设置指针和初始值
        while (i <= j) { // 在当前范围中还有需要查找的元素
            int m = (i + j) >>> 1; // 自动向下取整
            if (target < a[m]) { // 目标在中间值的左边
                j = m - 1;
            } else if (a[m] < target) { // 目标在中间值的右边
                i  = m + 1;
            } else { // 找到了
                return m;
            }
        }
        return -1;
    }


    /**
     * 二分查找改动版
     * @param a 待查找的升序数组
     * @param target 待查找的目标值
     * @return 找到返回索引，找不到返回-1
     */
    public static int binarySearchAlternative(int[] a, int target) {
        int i = 0, j = a.length;
        while (i < j) {
            int m = (i + j) >>> 1;
            if (target < a[m]) {
                j = m;
            } else if (a[m] < target) {
                i  = m + 1;
            } else {
                return m;
            }
        }
        return -1;
    }

    /**
     * 二分查找平衡版
     * @param a 待查找的升序数组
     * @param target 待查找的目标值
     * @return 找到返回索引，找不到返回-1
     */
    public static int binarySearch3(int[] a, int target) {
        int i = 0, j = a.length;
        while (1 < j - i) {
            int m = (i + j) >>> 1;
            if (target < a[m]) {
                j = m;
            } else {
                i = m;
            }
        }
        if (target == a[i]) {
            return i;
        } else {
            return -1;
        }
    }


    /**
     * java版二分查找，实现插入功能
     */
    public static void binarySearch4() {

        int[] a = {2, 5, 8};
        int target = 4;

        // java自带的工具类
        int i = Arrays.binarySearch(a, target);
        System.out.println(i);
        // -2 插入点
        // -2 + 1 = -插入点

        // 查找结果小于0，表示未找到，即可插入
        if (i < 0) {
            int insertIndex = Math.abs(i + 1); // 插入零点索引
            int[] b = new int[a.length + 1]; // 新数组
            System.arraycopy(a, 0, b, 0, insertIndex); // 从索引0开始复制到索引insertIndex的位置，半包
            b[insertIndex] = target;
            System.arraycopy(a, insertIndex, b, insertIndex + 1, a.length - insertIndex);
            Arrays.stream(b).forEach(System.out::println);
        }


    }


    /**
     *  重复元素时，查找最左边的元素
     * @param a 待查找的升序数组
     * @param target 待查找的目标值
     * @return 找到时返回索引，找不到返回-1
     */
    public static int binarySearchLeftmost1(int[] a, int target) {
        int i = 0, j = a.length -1;
        int candidate = -1; // 候选位置
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (target < a[m]) {
                j = m - 1;
            } else if (a[m] < target) {
                i  = m + 1;
            } else {
                // 记录候选位置
                candidate = m;
                j = m - 1; // 继续向左查找
            }
        }
        return candidate;
    }

    /**
     *  重复元素时，查找最右边的元素
     * @param a 待查找的升序数组
     * @param target 待查找的目标值
     * @return 找到时返回索引，找不到返回-1
     */
    public static int binarySearchRight1(int[] a, int target) {
        int i = 0, j = a.length -1;
        int candidate = -1; // 候选位置
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (target < a[m]) {
                j = m - 1;
            } else if (a[m] < target) {
                i  = m + 1;
            } else {
                // 记录候选位置
                candidate = m;
                i = m + 1; // 继续向右查找
            }
        }
        return candidate;
    }


}
