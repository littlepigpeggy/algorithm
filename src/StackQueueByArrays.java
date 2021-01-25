// 给定一个大小的数组，使用该数组实现定长的栈、队列结构

public class StackQueueByArrays {
    public static class StackByArray{
        // Integer和int 默认值null; 0 可以表示出未赋值的情况
        // index相当于栈顶指针
        private int[] arr;
        private Integer index;
        public StackByArray(int initSize){
            if (initSize < 0){
                throw new IllegalArgumentException("The initial size is less than 0!");
            }
            arr = new int[initSize];
            index = 0;
        }

        public Integer peek(){
            if (index == 0){
                return null;
            }
            return arr[index - 1];
        }

        public void push(int obj){
            if (index == arr.length){
                throw new ArrayIndexOutOfBoundsException("The stack is full.");
            }
            arr[index++] = obj;
        }

        public int pop(){
            if (index == 0){
                throw new ArrayIndexOutOfBoundsException("The stack is empty.");
            }
            return arr[--index];
        }
    }

    // 有默认值0，用int; 否则使用Integer
    public static class QueueByArray{
        private int size = 0;
        private int start = 0;
        private int end = 0;
        private int[] arr;
        public QueueByArray(int initSize){
            if (initSize < 0){
                throw new IllegalArgumentException("The initial size is less than 0!");
            }
            arr = new int[initSize];
        }

        public void In(int obj){
            if (size > arr.length){
                throw new ArrayIndexOutOfBoundsException("The queue is full.");
            }
            arr[end] = obj;
            end = (end + 1) % arr.length;
            ++size;
        }

        public int Out(){
            if (size <= 0){
                throw new ArrayIndexOutOfBoundsException("The queue is empty.");
            }
            int tmp = start;
            start = (start + 1) % arr.length;
            --size;
            return arr[tmp];
        }

    }
}
