package 数组;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.stream.IntStream;

/**
 * @Description 动态数组（支持数组的自动扩容）
 * @Create by hqx
 * @Date 2023/11/18 18:48
 */
public class DynamicArray implements Iterable<Integer> {
    private int size = 0; // 逻辑大小
    private int capacity = 8; // 容量
    private int[] array = {};


    /**
     * 添加元素到数组的末尾（size）
     * @param element 添加元素
     */
    public void addLast(int element) {
        //array[size] = element;
        //size++;
        add(size, element);
    }

    /**
     * 把元素添加到指定位置（0...size）
     * @param index 需要指定的索引位置
     * @param element 添加的元素
     */
    public void add(int index, int element) {
        checkAndGrow();
        if (index >= 0 && index <= size ) {
            System.arraycopy(array, index, array,
                    index + 1, size - index);
        } else {
            throw new RuntimeException("插入位置异常");
        }
        array[index] = element;
        size++;
    }

    /**
     * 数组容量检查和扩容
     */
    private void checkAndGrow() {
        // 容量检查
        if (size == 0) {
            // 进行元素添加时才指定数组的容量大小
            array = new int[capacity];
        } else if (size == capacity) {
            // 进行扩容 1.5倍扩容
            capacity += capacity >> 1;
            int[] newArray = new int[capacity];
            // 复制数组
            System.arraycopy(array, 0,
                    newArray, 0, size);
            array = newArray;
        }
    }


    /**
     * 删除元素
     * @param index 删除元素的索引
     * @return 删除的元素
     */
    public int remove(int index) {
        int removed = array[index];
        if (index < size - 1) { // 元素为逻辑最后位置时不执行
            System.arraycopy(array, index + 1, array,
                    index, size - index - 1);
        }
        size--;
        return removed;
    }


    /**
     * 查询元素
     * @param index 索引位置，在 [0, size）区间内
     * @return 该索引的元素
     */
    public int get(int index) {
        return array[index];
    }


    /**
     * 遍历方法1:
     * @param consumer 遍历要执行的操作，入参：每个元素
     */
    public void foreach(Consumer<Integer> consumer) {
        for (int i = 0; i < size; i++) {
            consumer.accept(array[i]);
        }
    }


    /**
     * 遍历方法2：迭代器遍历
     * @return
     */
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int i = 0;
            @Override
            public boolean hasNext() { // 又没有下一个元素
                return i < size;
            }

            @Override
            public Integer next() { // 返回当前元素，并移动到下一个元素
                return array[i++];
            }
        };
    }

    /**
     * 遍历方法3：转成stream流
     * @return
     */
    public IntStream stream() {
        // 只传有效的部分
        return IntStream.of(Arrays.copyOfRange(array, 0, size));
    }

}
