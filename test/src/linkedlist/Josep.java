package linkedlist;

/**
 * @Create by hqx
 * @Date 2023/10/24 21:55
 * @Description 单项环形链表解决约瑟夫问题
 */
public class Josep {

    public static void main(String[] args) {
        // 测试
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();

        // 添加5个子节点
        circleSingleLinkedList.addBoy(5);
        // 打印子节点
        circleSingleLinkedList.showBoy();
        // 需要配合addBoy方法使用
        circleSingleLinkedList.countBoy(1, 2, 5);
    }

}

// 创建一个单向的环形链表
class CircleSingleLinkedList {
    // 创建first结点，当前没有编号
    private Boy first = null;

    // 添加子节点，构建成一个环形的链表
    public void addBoy(int nums) {
        // 数据校验
        if (nums < 1) {
            System.out.println("nums 的值不正确");
            return;
        }

        Boy curBoy = null; // 辅助指针，帮助构建环形链表
        // 使用for来创建我们的链表
        for (int i = 1; i <= nums; i++) {
            // 根据编号创建子节点
            Boy boy = new Boy(i);
            // 如果是第一个子节点
            if (i == 1) {
                first = boy;
                first.setNext(first); // 构成环
                curBoy = first; // 指向第一个子节点
            } else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }

    /**
     * @param startNo 表示从第几个结点开始数
     * @param countNum 表示数几下
     * @param nums  表示最初有多少小孩在圈中
     */
    public void countBoy(int startNo, int countNum, int nums) {
        // 先对数据进行校验
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("参数输入有误，请重新输入");
            return;
        }
        // 创建要给辅助指针，帮助完成结点出圈
        Boy helper = first;
        // 需要创建一个辅助变量helper，事先应该指向环形链表的最后这个结点
        while (true) {
            if (helper.getNext() == first) { // 说明helper指向最后结点
                break;
            }
            helper = helper.getNext();
        }
        // 报数前，先让first 和 helper 移动 k - 1 次
        for (int i = 0; i < startNo -1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        // 当小孩报数时，让 first 和 helper 指针同时移动 m - 1 次，然后出圈
        // 这里是一个循环操作，直到圈中只有一个结点
        while (true) {
            if (helper == first) { // 说明圈中只有一个结点
                break;
            }
            // 让 first 和 helper 指针同时的移动 countNum - 1
            for (int i = 0; i < countNum -1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            // 此时 first 指向的结点，就是要出圈的结点
            System.out.printf("结点%d要出圈\n", first.getNo());
            // first 指向的结点出圈
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.printf("最后留在圈中的小孩编号%d", first.getNo());


    }


    // 遍历当前环形链表
    public void showBoy() {
        // 判断链表是否为空
        if (first == null) {
            System.out.println("链表无子节点");
            return;
        }
        Boy curBoy = first;
        while (true) {
            System.out.printf("子节点的编号:%d \n", curBoy.getNo());
            if (curBoy.getNext() == first) { // 说明遍历完毕
                break;
            }
            curBoy = curBoy.getNext();
        }

    }


}

// 创建Boy类，表示一个节点
class Boy {
    private int no; // 编号
    private Boy next; // 指向下一个节点

    public Boy(int no) {
        this.no = no;
    }


    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
