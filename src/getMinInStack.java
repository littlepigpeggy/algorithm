// 在实现栈的基本功能的基础上，实现返回栈中最小元素的操作
// 要求push(), pop(), getMin()时间复杂度为O(1)
// 可以直接使用基本的栈结构
//

// 建立两个栈
import java.util.Stack;

public class getMinInStack {
    private static int min;
    private static Stack<Integer> stack;
    private static Stack<Integer> mins;
    public getMinInStack() {
        stack = new Stack<>();
        mins = new Stack<>();
        //min = Integer.MAX_VALUE;
    }

    public static void push(int obj){
        stack.push(obj);
        if (mins.isEmpty()){
            mins.push(obj);
        }
        else if (obj < mins.peek()){
            mins.push(obj);
        }
        else {
            mins.push(mins.peek());
        }
    }

    public static int pop(){
        if (stack.isEmpty()){
            throw new ArrayIndexOutOfBoundsException("The stack is empty.");
        }
        int tmp = mins.pop();
        tmp = stack.pop();
        return tmp;
    }

    public static int getMin(){
        if (mins.isEmpty()){
            throw new ArrayIndexOutOfBoundsException("The stack is empty.");
        }
        else{
            return mins.peek();
        }
    }

    public static void main(String[] args){
        getMinInStack minStack = new getMinInStack();
        minStack.push(1);
        minStack.push(2);
        minStack.push(2);
        minStack.push(0);
        minStack.push(5);
        minStack.push(4);
        System.out.print("pop() is" + minStack.pop());
        System.out.print("getMin() is" + minStack.getMin());
    }
}
