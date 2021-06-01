package com.hf.threaded;

public class ThreadedBinaryTreeTest {
    public static void main(String[] args) {
        HeroNode root = new HeroNode(1, "root");
        HeroNode node2 = new HeroNode(2, "2");
        HeroNode node3 = new HeroNode(3, "3");
        HeroNode node4 = new HeroNode(4, "4");
        HeroNode node5 = new HeroNode(5, "5");
        HeroNode node6 = new HeroNode(6, "6");
        HeroNode node7 = new HeroNode(7, "7");
        HeroNode node8 = new HeroNode(8, "8");

        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);
        node3.setRight(node7);
        node4.setLeft(node8);
        ThreadBinaryTree threadBinaryTree = new ThreadBinaryTree();
        threadBinaryTree.setRoot(root);
//        threadBinaryTree.threadedBinary(root);
//        threadBinaryTree.preThreadedBinary(root);
        threadBinaryTree.postThreadedBinaryTree(root);

//        System.out.println("8的后继节点是="+node5.getRight());
//        threadBinaryTree.inifixOrder();
//        threadBinaryTree.preOrder();
        threadBinaryTree.postOrder();
    }
}

class ThreadBinaryTree {
    private HeroNode root;

    private HeroNode pre = null;

    public HeroNode getRoot() {
        return root;
    }

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    //中序线索化二叉树
    public void threadedBinary(HeroNode node) {
        if (node == null) {
            return;
        }
        if (node.getLeft() != null) {
            threadedBinary(node.getLeft());
        }
        if (node.getLeft() == null) {
            node.setLeft(pre);
            node.setLeftType(1);
        }
        //相当于链表，只标记了前置节点，能设置当前节点的前置节点，不能设置当前节点的后置节点，因为不知道后置节点是哪个
        //但是明确知道当前节点一定是前置节点的后置节点，所以通过设置前置节点的后置节点来做关联
        if (pre != null && pre.getRight() == null) {
            pre.setRight(node);
            pre.setRightType(1);
        }
        pre = node;
        if (node.getRight() != null) {
            threadedBinary(node.getRight());
        }
    }

    //中序遍历线索化二叉树
    public void inifixOrder() {
        HeroNode curNode = root;

        while (curNode != null) {
            //左子树，找到最左边的节点，输出
            while (curNode.getLeftType() != 1) {
                curNode = curNode.getLeft();
            }
            System.out.println(curNode);
            //找当前节点的后继节点，一直找，没有了就把遍历前节点的右子树
            while (curNode.getRightType() == 1) {
                curNode = curNode.getRight();
                System.out.println(curNode);
            }
            curNode = curNode.getRight();
        }
    }

    //前序线索化二叉树
    public void preThreadedBinary(HeroNode node) {
        if (node == null) {
            return;
        }
        if (node.getLeft() == null) {
            node.setLeft(pre);
            node.setLeftType(1);
        }

        if (pre != null && pre.getRight() == null) {
            pre.setRight(node);
            pre.setRightType(1);
        }
        pre = node;

        if (node.getLeftType() == 0 && node.getLeft() != null) {
            preThreadedBinary(node.getLeft());
        }

        if (node.getRightType() == 0 && node.getRight() != null) {
            preThreadedBinary(node.getRight());
        }
    }

    public void preOrder() {
        HeroNode curNode = root;
        while (curNode != null) {
            System.out.println(curNode);
            while (curNode.getLeftType() != 1) {
                curNode = curNode.getLeft();
                System.out.println(curNode);
            }

            while (curNode.getRightType() == 1) {
                curNode = curNode.getRight();
                System.out.println(curNode);
            }
            //当当前节点的左节点不是前置节点时，跳到左节点去遍历，是的话就退出，说明已经遍历过了
            if (curNode.getLeftType() == 1) {
                break;
            } else {
                curNode = curNode.getLeft();
            }
        }
    }

    public void postThreadedBinaryTree(HeroNode node) {
        if (node == null) {
            return;
        }

        if (node.getLeft() != null) {
            postThreadedBinaryTree(node.getLeft());
        }

        if (node.getRight() != null) {
            postThreadedBinaryTree(node.getRight());
        }

        if (node.getLeft() == null) {
            node.setLeft(pre);
            node.setLeftType(1);
        }

        if (pre != null && pre.getRight() == null) {
            pre.setRight(node);
            pre.setRightType(1);
        }
        pre = node;
    }

    public void postOrder() {
        HeroNode curNode = root;
        while (curNode != null) {
            HeroNode right = curNode.getRight();
            while (curNode.getLeftType() != 1) {
                curNode = curNode.getLeft();
            }
            System.out.println(curNode);
            while (curNode.getRightType() == 1) {
                curNode = curNode.getRight();
                System.out.println(curNode);
            }
            //如果右子树的根节点是叶子结点，就跳出循环
            if (right.getRightType() == 1) {
                break;
            }
            curNode = right;
        }
        //最后输出根节点
        System.out.println(root);
    }

}

class HeroNode {
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    private int leftType;
    private int rightType;


    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }


    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}




