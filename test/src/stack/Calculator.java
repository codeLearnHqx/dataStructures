package stack;

/**
 * @Description 栈实现计算器
 * @Create by hqx
 * @Date 2023/10/27 21:40
 */
public class Calculator {

    public static void main(String[] args) {
        // 表达式
        String expression = "7-4*3+4+2*3";
        // 创建两个栈，数栈，符号栈
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operatorStack = new ArrayStack2(10);
        // 定义相关变量
        int index = 0; // 用于扫描
        int num1 = 0;
        int num2 = 0;
        int operator = 0;
        int res = 0;
        char ch = ' '; // 每次扫描的char保存到ch
        String keepNum = ""; // 用于拼接多位数
        // 扫描expression
        while (true) {
            // 依次得到expression的每个字符
            ch = expression.substring(index, index + 1).charAt(0);
            // 判断ch是什么，然后做相应的处理
            if (operatorStack.isOperator(ch)) { // 如果是运算符
                // 判断当前的符号栈是否为空
                if (!operatorStack.isEmpty()) {
                    // 判断当前的操作符的优先级是否小于或者等于栈中的操作符
                    if (operatorStack.priority(ch) <= operatorStack.priority(operatorStack.peek())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        operator = operatorStack.pop();
                        res = numStack.cal(num1, num2, operator);
                        // 把运算的结果入数栈
                        numStack.push(res);
                        // 把当前的符号入符号栈
                        operatorStack.push(ch);
                    } else {
                        // 如果当前操作符的优先级大于栈中的操作符，就直接入符号栈
                        operatorStack.push(ch);
                    }
                } else {
                    // 符号栈如果为空直接入栈
                    operatorStack.push(ch);
                }
            } else { // 如果是数，就直接入数栈
                // ASCII表中 字符0 对应十进制数  48
                //numStack.push(ch - 48);  // 只能处理单位数
                // 1. 当处理多位数时，不能发现是一个数就立即入栈，因为它可能是多位数
                // 2. 在处理数时，需要向expression表达式的index后再看一位，如果是数就进行扫描，如果是符号才入栈
                // 3. 因此，我们需要定义一个变量 字符串，用于拼接

                // 处理多位数
                keepNum += ch;

                // 如果ch是expression的最后一位就直接入栈
                if (index == expression.length() - 1) {
                    numStack.push(Integer.parseInt(keepNum));
                } else {
                    // 判断下一个字符是不是数字，如果是数字，就继续扫描，如果是运算符就入栈
                    // 只是后面看一位，不是index++
                    if (operatorStack.isOperator(expression.substring(index + 1, index + 2).charAt(0))) {
                        // 下一位是操作符时，将多位数字符串入栈（e: "10"、"100"...）
                        numStack.push(Integer.parseInt(keepNum));
                        // 清空
                        keepNum = "";
                    }
                }

            }
            // 让 index + 1 ，并判断是否扫描到expression最后
            index++;
            if (index >= expression.length()) {
                break; // 扫描结束
            }
        }

        // 当表达式扫描完毕，就顺序的从数栈和符号栈中pop出相应的数和字符，并计算
        while (true) {
            // 如果符号栈为空，则计算到最后的结果，数栈中只有一个数字【结果】
            if (operatorStack.isEmpty()) {
                break;
            }
            // 计算
            num1 = numStack.pop();
            num2 = numStack.pop();
            operator = operatorStack.pop();
            res = numStack.cal(num1, num2, operator);
            numStack.push(res); // 入栈
        }
        System.out.printf("表达式%s = %d", expression, numStack.pop());

    }

}


//  表示栈
class ArrayStack2 {
    private final int maxSize; // 栈的大小
    private final int[] stack; // 数组，数组模拟栈，数据就放在该数组
    private int top = -1; // 栈顶，初始化为-1

    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize]; // 初始化数组
    }

    // 返回当前栈顶，但不出栈
    public int peek() {
        return stack[top];
    }

    // 栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    // 栈空
    public boolean isEmpty() {
        return top == -1;
    }

    // 入栈
    public void push(int value) {
        // 判断栈是否满
        if (isFull()) {
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = value;

    }

    // 出栈，将栈顶的数据返回
    public int pop() {
        // 判断栈是否空
        if (isEmpty()) {
            throw new RuntimeException("栈空");
        }
        int value = stack[top];
        top--;
        return value;
    }


    // 返回运算符的优先级，优先级是有程序员定义的，优先级使用数字表示
    // 数字越大，则优先级越高
    public int priority(int operator) { // char 与 int 可以混用
        if (operator == '*' || operator == '/') {
            return 1;
        } else if (operator == '+' || operator == '-') {
            return 0;
        } else {
            return -1; // 假设目前的表达式只有+，-，*，/
        }
    }

    // 判断是不是一个运算符
    public boolean isOperator(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    // 计算方法
    public int cal(int num1, int num2, int operator) {
        int res = 0; // 用于存放计算结果
        switch (operator) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1; // 注意顺序
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
        }
        return res;
    }


}







