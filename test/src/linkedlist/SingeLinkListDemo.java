package linkedlist;

import java.util.Stack;

/**
 * @Description
 * @Create by hqx
 * @Date 2023/9/16 15:21
 */
public class SingeLinkListDemo {
    public static void main(String[] args) {
        HeroNode node1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode node2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode node3 = new HeroNode(3, "吴用", "智多星");
        HeroNode node4 = new HeroNode(4, "林冲", "豹子头");

        SingeLinkList singeLinkList = new SingeLinkList();

        // 添加的节点根据排名进行排序
        singeLinkList.addByOrder(node4);
        singeLinkList.addByOrder(node1);
        singeLinkList.addByOrder(node3);
        singeLinkList.addByOrder(node2);
        singeLinkList.list();

        System.out.println("-----------------------");
        // 测试修改节点的代码
        HeroNode node5 = new HeroNode(2, "卢俊义sb", "玉麒麟");
        singeLinkList.list();
        singeLinkList.update(node5);
        System.out.println("修改后~~~~~~");
        singeLinkList.list();

        System.out.println("-----------------------");
        // 删除结点
        singeLinkList.list();
        singeLinkList.delete(1);
        System.out.println("删除后~~~~~~");
        singeLinkList.list();

        System.out.println(getLength(singeLinkList.getHead()));
        System.out.println(findLastIndexNode(singeLinkList.getHead(), 1));

        System.out.println("逆序打印单链表");
        singeLinkList.list();
        System.out.println("逆序后");
        reversePrint(singeLinkList.getHead());



    }

    // 获取有效结点个数

    /**
     * @param head 链表的头结点
     * @return 返回的是有效结点的个数
     */
    public static int getLength(HeroNode head) {
        if (head.next == null) {
            return 0;
        }
        int length = 0;
        HeroNode cur = head.next;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        return length;
    }

    /**
     * 获取倒数第k个结点
     * @param head 头节点
     * @param index 倒数第index个结点
     * @return
     */
    public static HeroNode findLastIndexNode(HeroNode head, int index) {
        if (head.next == null) {
            return null;
        }
        int nodeListSize = getLength(head);
        if (index <= 0 || index > nodeListSize) {
            return null;
        }
        HeroNode temp = head.next;
        for (int i = 0; i < (nodeListSize -index); i++) {
            temp = temp.next;
        }
        return temp;
    }

    // 使用栈的方式，实现单链表的逆序打印
    public static void reversePrint(HeroNode head) {
        if (head.next == null) {
            return; // 空链表不能打印
        }
        // 创建一个栈，将各个节点压入栈
        Stack<HeroNode> stack = new Stack<>();
        HeroNode cur = head.next;
        // 入栈
        while (cur != null) {
            stack.push(cur);
            cur = cur.next; // 后移
        }
        // 将栈中的结点进行打印，pop出栈
        while (stack.size() > 0) {
            System.out.println(stack.pop()); // 先进后出
        }
    }


}

// 单链表
class SingeLinkList {
    // 初始化头结点
    private HeroNode head = new HeroNode(0, "", "");

    // 获取头结点
    public HeroNode getHead() {
        return head;
    }

    // 不考虑编号顺序添加
    // 添加结点到链表中
    public void addNode(HeroNode node) {
        // 因为头结点不能动，所以需要辅助变量temp遍历链表
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            // 链表后移
            temp = temp.next;
        }
        // temp指向链表最后的节点
        temp.next = node;

    }

    // 考虑编号顺序添加
    // 添加时根据排名插入到指定位置
    public void addByOrder(HeroNode node) {
        HeroNode temp = head;
        boolean flag = false; // flag标志添加的编号是否存在，默认为false

        while (true) {
            // temp已经在链表的最后
            if (temp.next == null) {
                break;
            }
            // 位置找到，就在temp的后面插入
            if (temp.next.no > node.no) {
                break;
            }
            // 需要添加的节点已经存在
            if (temp.next.no == node.no) {
                flag = true;
                break;
            }
            // 后移，遍历当前链表
            temp = temp.next;
        }

        if (flag) {
            System.out.printf("需要添加的节点编号%d已经存在，不能加入\n", node.no);
        } else {
            // 将结点插入到指定位置，即temp的后面
            node.next = temp.next;
            temp.next = node;
        }


    }

    // 修改结点的信息，根据no编号来修改，即no编号不能改
    // 根据新的node的编号进行修改
    public void update(HeroNode node) {
        // 判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空~~~");
            return;
        }
        HeroNode temp = head.next;
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

    // 删除结点
    public void delete(int no) {
        HeroNode temp = head;
        boolean flag = false; // 标志是否找到待删除结点
        while (true) {
            // 链表遍历结束，已经到链表的最后
            if (temp.next == null) {
                break;
            }
            // 找到待删除结点的前一个节点
            if (temp.next.no == no) {
                flag = true;
                break;
            }
            // 后移
            temp = temp.next;
        }
        // 删除节点
        if (flag) {
            // 将待删除的前一个结点的next指向待删除结点的next，待删除结点未被任何引用，会被垃圾回收机制自动回收
            temp.next = temp.next.next;
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
        HeroNode temp = head.next;
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
class HeroNode {
    public int no; // 排名
    public String name;
    public String nickname;
    public HeroNode next;  // 指向下一个结点

    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }


    @Override
    public String toString() {
        return "linkedlist.HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}



