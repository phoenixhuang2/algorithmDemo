package com.hf.sorttest;


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}


public class InsertSortV2 {

    public ListNode insertionSort(ListNode head) {
        ListNode tmpNode = new ListNode(head.val);
        for (ListNode i = head.next, j, current; i != null;) {
            current = i;
            for (j=tmpNode; j !=null; ) {
                ListNode node = new ListNode(current.val);
                if (j.next != null && j.val <= current.val && j.next.val >= current.val) {
                    ListNode nextNode = j.next;
                    j.next = node;
                    j.next.next = nextNode;
                    break;
                } else if (j.next == null && j.val <= current.val) {
                    j.next = node;
                    break;
                } else if (j.next == null && j.val >= current.val) {
                    node.next = j;
                    tmpNode = node;
                    break;
                } else if (j == tmpNode && j.val >= current.val) {
                    node.next = j;
                    tmpNode = node;
                    break;
                }
                j = j.next;
            }
            i = i.next;
        }
        return tmpNode;
    }

    /**
     * 参考其他思路后的改进版本，不需要new节点
     * @param head
     * @return
     */
    public ListNode insertionSortV2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = new ListNode(0);
        ListNode pre = newHead;
        for (ListNode cur=head; cur!=null;) {
            ListNode tmp = cur.next;
            for (; pre.next != null;) {
                if (pre.next.val != cur.val && pre.next.val >= cur.val ) {
                    break;
                }
                pre = pre.next;
            }
            cur.next = pre.next;
            pre.next = cur;
            cur = tmp;
            pre = newHead;
        }
        return newHead.next;

    }

    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            while (pre.next != null && pre.next.val < cur.val) pre = pre.next;
            cur.next = pre.next;
            pre.next = cur;
            pre = dummy;
            cur = tmp;
        }
        return dummy.next;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(9);
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(5);
        ListNode node21 = new ListNode(9);
        ListNode node3 = new ListNode(10);
        ListNode node4 = new ListNode(2);
        head.next = node1;
        node1.next = node2;
        node2.next = node21;
        node21.next = node3;
        node3.next = node4;

        InsertSortV2 obj = new InsertSortV2();
        ListNode result = obj.insertionSortV2(head);
        for (ListNode i=result; ; ) {
            System.out.print(i.val+"->");
            if (i.next == null) break;
            i = i.next;
        }

    }
}
