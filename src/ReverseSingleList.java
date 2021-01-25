// 反转链表

import java.util.List;

public class ReverseSingleList {
    public static class ListNode{
        int val;
        ListNode next;
    }
    public static ListNode reverseSingleList(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        else {
            ListNode p = null;
            ListNode q = head;
            ListNode tmp;
            while (q != null){
                tmp = q.next;
                q.next = p;
                p = q;
                q = tmp;
            }
            return q;
        }
    }
}
