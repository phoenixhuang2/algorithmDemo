package com.hf.atguigutree;

public class BinaryTreeTest {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        HeroNode root = new HeroNode(1, "sj");
        HeroNode node1 = new HeroNode(2, "wy");
        HeroNode node2 = new HeroNode(3, "ljy");
        HeroNode node3 = new HeroNode(4, "lc");
        HeroNode node4 = new HeroNode(5, "lc");

        root.setLeft(node1);
        root.setRight(node2);
        node2.setRight(node3);
        node2.setLeft(node4);
        binaryTree.setRoot(root);

//        binaryTree.preFind(node3);
        binaryTree.preOrder();
        System.out.println("--------");
        binaryTree.del2(3);
        System.out.println("--------");
        binaryTree.preOrder();


    }
}

class BinaryTree {
    private HeroNode root;

    public HeroNode getRoot() {
        return root;
    }

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    public void preOrder() {
        if (this.root == null) {
            System.out.println("二叉树为空");
            return;
        }
        this.root.preOrder();
    }

    public void inifixOrder() {
        if (this.root == null) {
            System.out.println("二叉树为空");
            return;
        }
        this.root.inifixOrder();
    }


    public void postOrder() {
        if (this.root == null) {
            System.out.println("二叉树为空");
            return;
        }
        this.root.postOrder();
    }


    public HeroNode preFind(HeroNode node) {
        if (this.root == null) {
            System.out.println("二叉树为空");
            return null;
        }
        return this.root.preFind(node);
    }

    public void del(int no) {
        if (this.root == null) {
            System.out.println("二叉树为空");
            return;
        }
        if (this.root.getNo() == no) {
            this.root = null;
        } else {
            this.root.delNode(no);
        }
    }

    public void del2(int no) {
        if (this.root == null) {
            System.out.println("二叉树为空");
            return;
        }
        if (this.root.getNo() == no) {
            this.root = null;
        } else {
            this.root.delNode2(no);
        }
    }
}

class HeroNode {
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

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

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    //前序遍历
    public void preOrder() {
        System.out.println(this);
        if (this.getLeft() != null) {
            this.left.preOrder();
        }

        if (this.getRight() != null) {
            this.right.preOrder();
        }
    }

    public void inifixOrder() {
        if (this.getLeft() != null) {
            this.left.inifixOrder();
        }
        System.out.println(this);
        if (this.getRight() != null) {
            this.right.inifixOrder();
        }
    }

    public void postOrder() {
        if (this.getLeft() != null) {
            this.left.postOrder();
        }
        if (this.getRight() != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }


    public HeroNode preFind(HeroNode node) {
        if (this.no == node.getNo()) {
            System.out.println("找到啦。。"+this);
            return this;
        }
        HeroNode result = null;
        if (this.left != null) {
            result = this.left.preFind(node);
        }
        if (result != null) {
            return result;
        }
        if (this.right != null) {
            result = this.right.preFind(node);
        }
        return result;
    }

    public boolean delNode(int no) {
        boolean del = false;
        if (this.left != null) {
            if (this.left.getNo() == no) {
                System.out.println("找到了。。。");
                this.left = null;
                del = true;
                return del;
            }
            del = this.left.delNode(no);
        }

        if (del == true) {
            return del;
        }

        if (this.right != null) {
            if (this.right.getNo() == no) {
                System.out.println("找到了。。。");
                this.right = null;
                del = true;
                return del;
            }
            del = this.right.delNode(no);
        }

        return del;
    }

    public void delNode2(int no) {
        if (this.left != null && this.left.no == no) {
            if (this.left.left != null) {
                this.left.left.right = this.left.right;
                this.left = this.left.left;
            } else if (this.left.right != null) {
                this.left = this.left.right;
            } else {
                this.left = null;
            }
            return;
        }

        if (this.right != null && this.right.no == no) {
            if (this.right.left != null) {
                this.right = this.right.left;
            } else if (this.right.right != null) {
                this.right = this.right.right;
            } else {
                this.right = null;
            }
            return;
        }

        if (this.left != null) {
            this.left.delNode2(no);
        }

        if (this.right != null) {
            this.right.delNode2(no);
        }
    }
}
