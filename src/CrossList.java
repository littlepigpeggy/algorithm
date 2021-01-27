// 相交链表问题
// 分情况讨论 有环/无环
// 可用hash求解 注意链表问题常用hash
public class CrossList {
    public static class ListNode {
        int val;
        ListNode next;
    }

    // 两个链表都无环
    public static ListNode crossList(ListNode head1, ListNode head2) {
        ListNode start1 = head1;
        ListNode start2 = head2;
        int len1 = 0;
        int len2 = 0;
        ListNode end1 = null;
        ListNode end2 = null;
        while (head1 != null) {
            len1++;
            end1 = head1;
            head1 = head1.next;
        }
        while (head2 != null) {
            len2++;
            end2 = head2;
            head2 = head2.next;
        }
        if (end1 != end2) {
            return null;
        }
        for (int i = 0; i < len1 - len2; ++i) {
            start1 = start1.next;
        }
        while (start1 != start2) {
            start1 = start1.next;
            start2 = start2.next;
        }
        return start1;
    }

    // 若两个链表一个有环，一个无环，不可能相交

    // 若两个链表都有环，有三种拓扑结构
    // 1.不相交    2. 先相交再进环   3. 先进环后相交

    public static ListNode crossList2(ListNode head1, ListNode head2) {

        ListNode loop1 = hasRingList(head1);
        ListNode loop2 = hasRingList(head2);
        // 2.环的入口相同，即先相交再入环,使用无环链表判断相交的方法
        if (loop1 == loop2) {
            ListNode start1 = head1;
            ListNode start2 = head2;
            int len1 = 0;
            int len2 = 0;
            ListNode end1 = null;
            ListNode end2 = null;
            while (head1 != loop1) {
                len1++;
                end1 = head1;
                head1 = head1.next;
            }
            while (head2 != loop2) {
                len2++;
                end2 = head2;
                head2 = head2.next;
            }
            if (end1 != end2) {
                return null;
            }

            if (len1 > len2) {
                for (int i = 0; i < len1 - len2; ++i) {
                    start1 = start1.next;
                }
                while (start1 != start2) {
                    start1 = start1.next;
                    start2 = start2.next;
                }
                return start1;
            } else {
                for (int i = 0; i < len2 - len1; ++i) {
                    start2 = start2.next;
                }
                while (start1 != start2) {
                    start1 = start1.next;
                    start2 = start2.next;
                }
                return start1;
            }
        } else {
            ListNode tmp = loop1;
            while (loop1 != loop2) {
                loop1 = loop1.next;
                if (loop1 == tmp) {
                    break;
                }
            }
            if (loop1 == loop2) {
                // 3. 先进环再相交
                return tmp;
                // 返回loop2也可，因为是各自最近的结点
                // return loop2;
            } else {
                // 1.不相交
                return null;
            }
        }

    }


    // 寻找链表的环
    public static ListNode hasRingList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode p = head;
        ListNode q = head;
        while (p.next != null) {
            if (p.next.next != null) {
                p = p.next.next;
                q = q.next;
            } else {
                return null;
            }
            if (p == q) {
                p = head;
                while (p != q) {
                    p = p.next;
                    q = q.next;
                }
                return p;
            }
        }
        return null;
    }
}
