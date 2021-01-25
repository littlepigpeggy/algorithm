// 链表题目
// 笔试中遇到，不用考虑空间复杂度 能AC就行
// 面试中遇到，尽量优化

import java.util.Stack;

// 回文链表问题 栈 leetcode-234
public class HuiWenList {
    public static class ListNode{
        int val;
        ListNode next;
    }

    // 回文最直观的解法——栈解法，需要占用额外空间
    public static boolean isHuiWen1(ListNode head){
        if (head.next == null){
            return true;
        }
        Stack<Integer> stack = new Stack<>();
        ListNode p = head;
        while (p != null){
            stack.push(p.val);
            p = p.next;
        }

        while (head != null){
            if (head.val != stack.pop()){
                return false;
            }
            head = head.next;
        }
        return true;
    }

    // 可以用快慢指针实现，先找链表的中点，占用的额外空间复杂度小一点
    public static boolean isHuiWen2(ListNode head){
        ListNode p = head;
        ListNode q = head;
        Stack<Integer> stack = new Stack<>();
        while (p.next != null){
            if (p.next.next != null){
                p = p.next.next;
            }
            else {
                p = p.next;
            }
            head = head.next;
        }
        p = head;
        while (head != null){
            stack.push(head.val);
            head = head.next;
        }

        while (q != head){
            if (q.val != stack.pop()){
                return false;
            }
            q = q.next;
        }
        return true;

    }

    // 快慢指针 空间优化版本 不需要使用额外空间

    public static boolean isHuiWen3(ListNode head){
        ListNode p = head;
        ListNode q = head;
        // Stack<Integer> stack = new Stack<>();
        while (p.next != null){
            if (p.next.next != null){
                p = p.next.next;
            }
            else {
                p = p.next;
            }
            head = head.next;
        }

        // 若为奇数个，走到中间结点 偶数个，走到中间偏后一个结点
        p = null;
        ListNode tmp;
        while (head.next != null){
            tmp = head.next;
            head.next = p;
            p = head;
            head = tmp;
        }
        head.next = p;
        while (q != null && head != null){
            if (q.val !=  head.val){
                return false;
            }
            q = q.next;
            head = head.next;
        }
        return true;
    }

    public static void main(String[] args){

    }
}
