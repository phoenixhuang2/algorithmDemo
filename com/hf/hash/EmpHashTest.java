package com.hf.hash;

import java.util.Scanner;

public class EmpHashTest {
    public static void main(String[] args) {
        HashEmp hashEmp = new HashEmp(9);
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            switch (scanner.next()) {
                case "add":
                    System.out.println("输入id");
                    int id = scanner.nextInt();
                    System.out.println("输入name");
                    String name = scanner.next();
                    Emp emp = new Emp(id, name);
                    hashEmp.add(emp);
                    break;
                case "list":
                    hashEmp.list();
                    break;
                case "find":
                    System.out.println("输入id");
                    int findId = scanner.nextInt();
                    Emp emp1 = new Emp(findId, "");
                    hashEmp.find(emp1);
                    break;
                case "del":
                    System.out.println("输入id");
                    int delId = scanner.nextInt();
                    Emp emp2 = new Emp(delId, "");
                    hashEmp.del(emp2);
                    break;
                default:
                    break;
            }
        }
    }
}

class HashEmp {
    private EmpLinkList[] empLinkListArray;
    private int size;
    public HashEmp(int size) {
        this.size = size;
        empLinkListArray = new EmpLinkList[size];
        for (int i=0; i<size; i++) {
            empLinkListArray[i] = new EmpLinkList();
        }
    }

    public void add(Emp emp) {
        empLinkListArray[hashFun(emp.getId())].add(emp);
    }

    public void list() {
        for (int i=0; i<size; i++) {
            empLinkListArray[i].list();
        }
    }

    public void find(Emp emp) {
        empLinkListArray[hashFun(emp.getId())].find(emp);
    }

    public void del(Emp emp) {
        empLinkListArray[hashFun(emp.getId())].del(emp);
    }

    private int hashFun(int id) {
        return id % size;
    }
}

class Emp {
    private int id;
    private String name;
    public Emp next = null;

    public Emp() {
    }

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class EmpLinkList {
    private Emp head = null;

    public void add(Emp emp) {
        if (head == null) {
            head = emp;
        } else {
            Emp temp = head;
            while (true) {
                if (temp.next == null) {
                    temp.next = emp;
                    break;
                }
                temp = temp.next;
            }
        }
    }

    public void find(Emp emp) {
        if (head == null) {
            System.out.println("链表为空");
            return;
        }
        Emp temp = head;
        while (true) {
            if (temp.getId() == emp.getId()) {
                System.out.println("找到了, name="+temp.getName());
                break;
            }
            if (temp.next == null) {
                System.out.println("没有找到");
                break;
            }
            temp = temp.next;
        }
    }

    public void list() {
        if (head == null) {
            System.out.println("链表为空");
            return;
        }
        Emp temp = head;
        while (true) {
            System.out.printf("id=%d,name=%s ", temp.getId(), temp.getName());
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        System.out.println();
    }

    public void del(Emp emp) {
        if (head == null) {
            System.out.println("链表为空");
            return;
        }

        if (head.getId() == emp.getId()) {
            head = head.next;
            return;
        }

        Emp temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.getId() == emp.getId()) {
                System.out.println("删除name="+temp.next.getName());
                temp.next = temp.next.next;
                break;
            }

            temp = temp.next;
        }


    }

    // 删除雇员
    public void del2(Emp emp) {
        if(head == null) {
            System.out.println("该链表为空！");
            return;
        }
        // 当头结点的id等于要查找的id，直接删除
        if (head.getId() == emp.getId()) {
            head = head.next;
            return;
        }
        Emp temp = head;// 定义辅助节点
        boolean flag = false;
        while (true) {

            if (temp.next == null) {
                break;// 说明没有找到该点
            }
            if (temp.next.getId() == emp.getId()) {
                // 删除操作
                flag = true;
                break;
            }
        }
        if (flag) {
            // 找到该id，删除
            temp.next = temp.next.next;
        } else {
            System.out.println("没有找到该员工！");
        }
    }

}