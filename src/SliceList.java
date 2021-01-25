// 分割链表问题
// 可解leetcode-86

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;

public class SliceList {
    public static class ListNode{
        int val;
        ListNode next;
    }

    // 给定一个链表和一个指定值，小于num的在左边，大于num的在右边
    // 解1：基于数组的荷兰国旗问题
    // 缺点：空间复杂度高，不具备稳定性
    public static void sliceList1(ListNode head, int num){
        ArrayList<ListNode> list = new ArrayList<>();
        while (head != null){
            list.add(head);
            head = head.next;
        }
        int less = -1;
        int more = list.size();
        int i = 0;
        while (i < more){
            if (list.get(i).val > num){
                swap(list, i, --more);
            }
            else if (list.get((i)).val < num){
                swap(list, i++, ++less);
            }
            else {
                i++;
            }
        }
        for (i = 0; i < list.size() - 1; ++i) {
            list.get(i).next = list.get(i+1);
        }
        list.get(i).next = null;
    }

    // 解2：桶排序的思想——神解
    // 定义less, equal, more
    public static ListNode sliceList2(ListNode head, int num){
        ListNode less = null;
        ListNode equal = null;
        ListNode more = null;
        ListNode p = head;
        while (head != null){
            if (head.val < num){
                less = less == null ? head : less;
            }
            else if (head.val == num){
                equal = equal == null ? head : equal;
            }
            else {
                more = more == null ? head : more;
            }
            head = head.next;
        }
        ListNode link0 = less;
        ListNode link1 = equal;
        ListNode link2 = more;
        while (p != null){
            if (p.val < num){
                if (less != p){
                    less.next = p;
                    less = p;
                }
            }
            else if (p.val > num){
                if (more != p){
                    more.next = p;
                    more = p;
                }
            }
            else {
                if (equal != p){
                    equal.next = p;
                    equal = p;
                }
            }
            p = p.next;
        }
        if (less == null && link1 == null && link2 == null){
            return null;
        }
        else if (less == null && link1 == null && link2 != null){
            more.next = null;
            return link2;
        }
        else if (less == null && link1 != null && link2 == null){
            equal.next = null;
            return link1;
        }
        else if (less == null && link1 != null && link2 != null){
            equal.next = link2;
            more.next = null;
            return link1;
        }
        else if (less != null && link1 == null && link2 == null){
            less.next = null;
            return link0;
        }
        else if (less != null && link1 == null && link2 != null){
            less.next = link2;
            more.next = null;
            return link0;
        }
        else if (less != null && link1 != null && link2 == null){
            less.next = link1;
            equal.next = null;
            return link0;
        }
        else {
            less.next = link1;
            equal.next = link2;
            more.next = null;
            return link0;
        }
    }

    public static void swap(ArrayList<ListNode> list, int i, int j){
        ListNode tmp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, tmp);
    }
}
