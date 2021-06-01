package com.hf.link;

import java.util.*;

/**
 * 合并两个有序链表，
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }

     public static void main(String[] args) {
         Solution s = new Solution();
//         ListNode head = new ListNode(1);
//         s.add(head, new ListNode(2));
//         s.add(head, new ListNode(4));
//
//         ListNode head2 = new ListNode(1);
//         s.add(head2, new ListNode(3));
//         s.add(head2, new ListNode(4));
//
//         ListNode res = s.mergeTwoLists(head, head2);
//         s.list(res);

         ListNode head = new ListNode(1);
         s.add(head, new ListNode(1));
         s.add(head, new ListNode(2));
         s.add(head, new ListNode(3));
         s.add(head, new ListNode(2));
         s.add(head, new ListNode(1));
//         s.list(head);
         s.isPalindrome(head);
     }
}


class Solution {
    public void add(ListNode head, ListNode node) {
        ListNode cur = head;
        while (true) {
            if (cur.next == null) {
                break;
            }
            cur = cur.next;
        }
        cur.next = node;
    }

    public void list(ListNode head) {
        if (head.next == null) {
            System.out.println("链表没有元素。。。");
            return;
        }
        ListNode temp = head;
        while(true) {
            if (temp == null) {
                break;
            } else {
                System.out.println(temp.val);
            }
            temp = temp.next;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode mergeRes = new ListNode(0);

        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode next1 = null;
        ListNode next2 = null;

        ListNode newCur = mergeRes;

        while(true) {
            if (cur1 == null && cur2 != null) {
                newCur.next = cur2;
                break;
            }

            if (cur1 != null && cur2 == null) {
                newCur.next = cur1;
                break;
            }

            if (cur1 == null && cur2 == null) {
                break;
            }

            next1 = cur1.next;
            next2 = cur2.next;

            if (cur1.val < cur2.val) {
                newCur.next = cur1;
                cur1.next = null;
                cur1 = next1;
                newCur = newCur.next;
            }  else if (cur1.val > cur2.val) {
                newCur.next = cur2;
                cur2.next = null;
                cur2 = next2;
                newCur = newCur.next;
            } else {
                newCur.next = cur1;
                cur1.next = null;
                cur1 = next1;
                newCur = newCur.next;

                newCur.next = cur2;
                cur2.next = null;
                cur2 = next2;
                newCur = newCur.next;
            }
//            list(mergeRes);
        }
        return mergeRes.next;
    }

    /**
     * 环形链表判断：借助Set中不能有重复元素做判断处理
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        Set<ListNode> nums = new HashSet<ListNode>();
        ListNode cur = head;
        while(true) {
            if (cur.next == null) {
                return false;
            }
            if (!nums.add(cur)) {
                return true;
            }
            cur = cur.next;
        }
    }

    public boolean isPalindrome(ListNode head) {
        //生成逆序的链表，看与原链表是否相同
        ListNode newHead = new ListNode(0);
        ListNode cur = head;
        ListNode next = null;
        ArrayList<Integer> nums = new ArrayList<>();
        while (true) {
            if (cur == null) {
                break;
            }
            nums.add(cur.val);
            next = cur.next;
            cur.next = newHead.next;
            newHead.next = cur;
            cur = next;
        }
        cur = newHead.next;
        int index = 0;
        while (true) {
            if (cur == null) {
                break;
            }
            if (cur.val == nums.get(index++)) {
                cur = cur.next;
            } else {
                return false;
            }
        }
        return true;
    }
}
