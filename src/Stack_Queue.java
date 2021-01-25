// 队列结构实现栈结构
// 栈结构实现队列结构

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Stack_Queue {
    public static class StackByQueue{
        private Queue<Integer> queue1;
        private Queue<Integer> queue2;
        public StackByQueue(){
            queue1 = new ArrayDeque<>();
            queue2 = new ArrayDeque<>();
        }

        public void in(Integer obj){
            if (queue1.isEmpty() && queue2.isEmpty()){
                queue1.add(obj);
            }
            else if (queue1.isEmpty()){
                queue2.add(obj);
            }
            else{
                queue1.add(obj);
            }
        }

        public Integer out(){
            int tmp = 0;
            if(queue1.isEmpty()){
                while(queue2.size() > 1){
                    queue1.add(queue2.poll());
                }
                tmp = queue2.poll();
                return tmp;
            }
            else if(queue2.isEmpty()){
                while(queue1.size() > 1){
                    queue2.add(queue1.poll());
                }
                tmp = queue1.poll();
                return tmp;
            }
            return tmp;
        }

        public Integer top() {
            int tmp = 0;
            if(queue1.isEmpty()){
                while(queue2.size() > 1){
                    queue1.add(queue2.poll());
                }
                tmp = queue2.poll();
                queue1.add(tmp);
                return tmp;
            }
            else if(queue2.isEmpty()){
                while(queue1.size() > 1){
                    queue2.add(queue1.poll());
                }
                tmp = queue1.poll();
                queue2.add(tmp);
                return tmp;
            }
            return tmp;
        }

        public boolean empty() {
            if(queue1.isEmpty() && queue2.isEmpty()){
                return true;
            }
            else{
                return false;
            }
        }
    }

    public static class QueueByStack{
        private Stack<Integer> stackIn;
        private Stack<Integer> stackOut;
        public QueueByStack(){
            stackIn = new Stack<>();
            stackOut = new Stack<>();
        }
        public void push(int x) {
            stackIn.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            if (stackOut.isEmpty()){
                while (stackIn.size() > 0){
                    stackOut.push(stackIn.pop());
                }
                return stackOut.pop();
            }
            else{
                return stackOut.pop();
            }
        }

        /** Get the front element. */
        public int peek() {
            if (stackOut.isEmpty()){
                while (stackIn.size() > 0){
                    stackOut.push(stackIn.pop());
                }
                return stackOut.pop();
            }
            else{
                return stackOut.pop();
            }
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            if (stackIn.isEmpty() && stackOut.isEmpty()){
                return true;
            }
            else{
                return false;
            }
        }
    }
}
