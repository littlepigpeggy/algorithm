import java.util.HashSet;

// 判断链表是否有环
// leetcode-141
public class HasRingList {
    public static class ListNode{
        int val;
        ListNode next;
    }

    // hashset方法求解
    public boolean hasRingList1(ListNode head){
        HashSet<ListNode> list = new HashSet<>();
        while (head != null){
            if (list.contains(head)){
                return true;
            }
            else {
                list.add(head);
            }
            head = head.next;
        }
        return false;
    }

    // 快慢指针求解 若有环，两指针必定相遇
    public ListNode hasRingList2(ListNode head){
        if (head == null){
            return null;
        }
        ListNode p = head;
        ListNode q = head;
        while (p.next != null){
            if (p.next.next != null){
                p = p.next.next;
                q = q.next;
            }
            else {
                return null;
            }
            if (p == q){
                p = head;
                while(p != q){
                    p = p.next;
                    q = q.next;
                }
                return p;
            }
        }
        return null;
    }
}
