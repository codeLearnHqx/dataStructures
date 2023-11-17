package linkedlist;


/**
 * @Description
 * @Create by hqx
 * @Date 2023/9/16 15:21
 */
public class DoubleLinkListDemo {
    public static void main(String[] args) {
        // 测试
        HeroNode2 node1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 node2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 node3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 node4 = new HeroNode2(4, "林冲", "豹子头");

        // 创建双向链表
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.addNode(node1);
        doubleLinkedList.addNode(node2);
        doubleLinkedList.addNode(node3);
        doubleLinkedList.addNode(node4);

        doubleLinkedList.list();
        // 修改
        HeroNode2 updateNode = new HeroNode2(4, "林冲sb", "豹子头");
        doubleLinkedList.update(updateNode);
        System.out.println("修改后");
        doubleLinkedList.list();

        // 删除
        doubleLinkedList.delete(2);
        System.out.println("删除后");
        doubleLinkedList.list();

    }
}



// 双向链表类
class DoubleLinkedList {
    // 初始化头结点
    private HeroNode2 head = new HeroNode2(0, "", "");
    // 获取头结点
    public HeroNode2 getHead() {
        return head;
    }



    // 添加结点到双向链表的最后
    public void addNode(HeroNode2 node) {
        // 因为头结点不能动，所以需要辅助变量temp遍历链表
        HeroNode2 temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            // 链表后移
            temp = temp.next;
        }
        // temp指向链表最后的节点
        temp.next = node; // 最后一个节点的下一个节点指向新添加的结点
        node.pre = temp; // 新添加结点的上一个结点执行最后一个结点
    }


    // 根据新的node的编号进行修改（与单链表的修改方式一样）
    public void update(HeroNode2 node) {
        // 判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空~~~");
            return;
        }
        HeroNode2 temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break; // 链表遍历结束
            }
            if (temp.no == node.no) {
                // 找到
                flag = true;
                break;
            }
            temp = temp.next;
        }
        // 根据flag判断是否找到要修改的节点
        if (flag) {
            temp.name = node.name;
            temp.nickname = node.nickname;
        } else { // 未找到
            System.out.printf("未找到 编号%d 的节点，不能修改\n", node.no);
        }

    }


    // 从双向链表中删除一个结点
    // 对于双向链表可以实现自我删除，不需要辅助结点
    public void delete(int no) {

        if (head.next == null) { // 空链表
            System.out.println("链表为空，无法删除");
            return;
        }
        HeroNode2 temp = head.next;
        boolean flag = false; // 标志是否找到待删除结点
        while (true) {
            // 链表遍历结束，已经到链表的最后结点的next
            if (temp == null) {
                break;
            }
            // 找到待删除结点的前一个节点
            if (temp.no == no) {
                flag = true;
                break;
            }
            // 后移
            temp = temp.next;
        }
        // 删除节点
        if (flag) {
            temp.pre.next = temp.next;
            if (temp.next != null) { // 不是最后一个节点执行
                temp.next.pre = temp.pre;
            }
        } else {
            System.out.printf("链表不存在 编号%d 的节点，无法删除\n", no);
        }
    }



    // 显示链表【遍历】
    public void list() {
        // 判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        // 通过辅助变量来遍历链表
        HeroNode2 temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            // 后移
            temp = temp.next;
        }
    }

}


// 定义HeroNode，每个HeroNode 对象就是一个结点
class HeroNode2 {
    public int no; // 排名
    public String name;
    public String nickname;
    public HeroNode2 next;  // 指向下一个结点
    public HeroNode2 pre; // 指向前一个结点

    public HeroNode2(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }


    @Override
    public String toString() {
        return "HeroNode2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}


