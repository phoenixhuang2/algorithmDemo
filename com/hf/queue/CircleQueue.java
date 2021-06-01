package com.hf.queue;

/**
 * 通过取模运算达到环形队列的效果
 * 取模：n%n = 0;能回到数组开始位置
 */
public class CircleQueue {
    private int[] circleArray;
    private int front;
    private int rear;
    private int maxSize;
    public CircleQueue(int maxSize) {
        this.maxSize = maxSize;//此中情况下约定，rear指向最后一个元素的下一个位置。队列实际存储的元素个数为maxSize-1
        this.front = 0;
        this.rear = 0;
        this.circleArray = new int[this.maxSize];
    }

    /**
     * 判断是否为空
     * @return
     */
    public boolean isEmpty() {
        return this.front == this.rear;
    }

    public boolean isFull() {
       return (this.rear + 1) % this.maxSize == this.front;
    }

    public int showSize() {
        return (this.rear + this.maxSize - this.front) % this.maxSize;
    }


    public void add(int n) {
        if (this.isFull()) {
            System.out.println("队列已满。。。");
            return;
        }
        this.circleArray[this.rear] = n;
        this.rear = (this.rear + 1) % this.maxSize;
        return;
    }


    public int get() {
        if (this.isEmpty()) {
            throw new RuntimeException("队列为空，没有数据。。");
        };
        int n = this.circleArray[this.front];
        this.front = (this.front + 1) % this.maxSize;
        return n;
    }

    public void show() {
        if (this.isEmpty()) {
            throw new RuntimeException("队列为空，没有数据。。。");
        }

        for (int i=front; i< front+showSize(); i++) {
            System.out.printf("circleArray[%d]=%d", (i % this.maxSize), this.circleArray[i%this.maxSize]);
            System.out.println();
        }
    }


    public static void main(String[] args) {
        CircleQueue cq  = new CircleQueue(4);
        cq.add(10);
        cq.add(20);
        cq.add(30);
        cq.show();

    }
}
