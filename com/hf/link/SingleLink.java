package com.hf.link;

public class SingleLink {
    private Node head = new Node(0, "", "");

    public void add(Node node) {

        //先把链表头赋值给一个临时遍历
        Node temp = head;
        //添加到链表尾
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = node;

    }

    /**
     * 有序插入
     * @param node
     */
    public void addSort(Node node) {
        Node temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            //敲黑板：temp是添加位置的前一个节点，所以拿temp的next 与节点比较
            if (temp.next.no > node.no) {
                break;
            } else if (temp.next.no == node.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (true == flag) {
            System.out.println("元素已经存在");
            return;
        }
        node.next = temp.next;
        temp.next = node;
    }

    public void list() {
        if (head.next == null) {
            System.out.println("链表没有元素。。。");
            return;
        }
        Node temp = head;
        while(true) {
            if (temp.next == null) {
                break;
            } else {
                System.out.println(temp.next);
            }
            temp = temp.next;
        }
    }

    public void delete(Node node) {
        if (head.next == null) {
            System.out.println("链表没有元素。。。");
            return;
        }
        Node temp = head;
        boolean flag = false;
        while(true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == node.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag == true) {
            temp.next = temp.next.next;
        } else {
            System.out.println("没有找到该元素");
        }
    }

    public void reverse() {
        Node newHead = new Node(0, "", "");
        Node cur = head.next;
        Node next = null;
        while (true) {
            if (cur == null) {
                break;
            }
            next = cur.next;
            cur.next = newHead.next;
            newHead.next = cur;
            cur = next;
        }

        head.next = newHead.next;
    }

    public static void main(String[] args) {
        SingleLink sl = new SingleLink();
        sl.addSort(new Node(2, "pengjiqun", "jq"));
        sl.addSort(new Node(1, "huangfeng", "xf"));
        sl.addSort(new Node(3, "pengyuhang", "ff"));
        sl.list();
        System.out.println("=============");

//        sl.reverse();
//        sl.list();


        sl.delete(new Node(1, "huangfeng", "xf"));
//        sl.delete(new Node(2, "pengjiqun", "jq"));
//        sl.delete(new Node(1, "huangfeng", "xf"));
//        sl.delete(new Node(3, "pengyuhang", "ff"));
        sl.list();
    }

}

class Node {
    public int no;
    public String name;
    public String nickName;
    public Node next;

    public Node(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
