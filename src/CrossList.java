import java.util.List;

// 相交链表问题
// 分情况讨论 有环/无环
// 可用hash求解 注意链表问题常用hash
public class CrossList {
    public static class ListNode{
        int val;
        ListNode next;
    }

    // 两个链表都无环
    public static ListNode crossList(ListNode head1, ListNode head2){
        ListNode start1 = head1;
        ListNode start2 = head2;
        int len1 = 0;
        int len2 = 0;
        ListNode end1 = null;
        ListNode end2 = null;
        while (head1 != null){
            len1++;
            end1 = head1;
            head1 = head1.next;
        }
        while (head2 != null){
            len2++;
            end2 = head2;
            head2 = head2.next;
        }
        if (end1 != end2){
            return null;
        }
        for (int i = 0; i < len1 - len2; ++i){
            start1 = start1.next;
        }
        while (start1 != start2){
            start1 = start1.next;
            start2 = start2.next;
        }
        return start1;
    }

    // 若两个链表一个有环，一个无环，不可能相交
    //
}
