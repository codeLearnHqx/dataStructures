import java.util.Scanner;

/**
 * @Description
 * @Create by hqx
 * @Date 2023/9/15 12:22
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {

        System.out.println("测试数组模拟环形队列的案例~~~");
        // 创建一个环形队列
        ArrayQueue queue = new ArrayQueue(4); // 设置4，其队列的有效数据最大为3

        char key = ' '; // 接收用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        // 输出一个菜单
        while (loop) {
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列中取出数据");
            System.out.println("h(head): 查看队列头的数据");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's': // 展示队列
                    queue.showQueue();
                    break;
                case 'a': // 往队列中添加数据
                    System.out.print("输入一个数：");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g': // 取出数据
                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出的数据是：%d\n", res);
                    }catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h': // 查看队列头的数据
                    try {
                        int res = queue.showHead();
                        System.out.printf("队列头的数据是：%d\n", res);
                    }catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e': // 退出
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }

        System.out.println("系统退出了");
    }
}


// 使用数组模拟一个环形队列
class ArrayQueue {
    private int maxSize; // 数组的最大容量
    private int front; // 队列头
    private int rear; // 队列尾
    private int[] arr; // 用于存放数据，模拟队列

    // 创建队列的构造器
    public ArrayQueue(int arrMaxSize) {
        this.maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = 0; // 指向队列头部，即队列的第一个数据
        rear = 0;  // 指向队列尾，指向队列的最后一个数据的后面一个（即永远留数组的一项为空）
    }


    // 添加队列数据
    public void addQueue(int value) {
        if (isFull()) {
            System.out.println("队列已满");
            return;
        }
        arr[rear] = value;
        rear = (rear + 1) % maxSize; // 队列满的时候rear为0
    }
    // 从队列中取出数据
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，没有数据~~~~");
        }
        int value = arr[front];
        front = (front + 1) % maxSize; // 队列数据取完的时候front为0
        return value;
    }

    // 判断队列是否满
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    // 判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    // 显示队列所有数据
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空，没有数据~~~~");
        }
        // 遍历有效数据（从队列头开始展示队列数据）
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n",i % maxSize, arr[i % maxSize]);
        }

    }

    // 队列当前有效数据的个数
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    // 显示队列头数据
    public int showHead() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，没有数据~~~~");
        }
        return arr[front];
    }


}

