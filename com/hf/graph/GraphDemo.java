package com.hf.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author huangfeng
 * @Date: Created in 5:44 下午 2020/12/2
 * @Description
 **/
public class GraphDemo {
    int[][] graph;
    List<String> points;
    boolean[] isVisited;
    int edges;

    public GraphDemo(int n) {
        graph = new int[n][n];
        points = new ArrayList<String>(n);
        isVisited = new boolean[n];
        edges = 0;
    }

    public void addPoints(String point) {
        points.add(point);
    }

    public void addEdges(int p1, int p2, int weight) {
        graph[p1][p2] = weight;
        graph[p2][p1] = weight;
        edges++;
    }

    public void show() {
        for (int i = 0; i < points.size(); i++) {
            System.out.println(Arrays.toString(graph[i]));
        }
    }

    public void dfs() {
        for (int i = 0; i < points.size(); i++) {
            if (!isVisited[i]) {
                dfs(i);
            }
        }
    }


    //深度遍历
    public void dfs(int n) {
        isVisited[n] = true;
        System.out.print(points.get(n)+"->");
        int x = getFirstPoint(n);
        while (x != -1) {
            if (!isVisited[x]) {
                dfs(x);
            }
            x = getPrePointNextPoint(n, x);
        }
//        if (x > 0 && !isVisited[x]) {
//            dfs(x);
//        } else {
//           int y = getPrePointNextPoint(n, x);
//           if (y > 0 && !isVisited[y]) {
//               dfs(y);
//           }
//        }
    }

    public void bfs(int n) {
        LinkedList queue = new LinkedList();
        queue.addLast(n);
        isVisited[n] = true;
        System.out.print(points.get(n)+"->");

        int u;
        int next;
        while (!queue.isEmpty()) {
            u = (Integer)queue.removeFirst();
            next = getFirstPoint(u);
            while (next != -1) {
                if (!isVisited[next]) {
                    System.out.print(points.get(next) + "->");
                    isVisited[next] = true;
                    queue.addLast(next);
                }
                next = getPrePointNextPoint(u, next);
            }
        }
    }

    public void bfs() {
        for (int i = 0; i < points.size(); i++) {
            if (!isVisited[i]) {
                bfs(i);
            }
        }
    }

    /**
     * 获取上一个节点的，下一个邻接节点，比如 当前节点是C,前一个节点是B，C的下一个节点只有一个A已经访问过了，
     * 所以需要回到上一节点B,继续找B的下一个未访问过的节点
     * @param pre x的上一个节点
     * @param x 当前访问的节点
     * @return
     */
    private int getPrePointNextPoint(int pre, int x) {
        for (int i = x+1; i < points.size(); i++) {
            if (graph[pre][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 获取第一个节点
     * @param x
     * @return
     */
    private int getFirstPoint(int x) {
        for (int i = 0; i < points.size(); i++) {
            if (graph[x][i] > 0) {
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        GraphDemo graphDemo = new GraphDemo(8);
//        graphDemo.addPoints("A");
//        graphDemo.addPoints("B");
//        graphDemo.addPoints("C");
//        graphDemo.addPoints("D");
//        graphDemo.addPoints("E");
//
//        //A-B A-C B->C B-D B-E
//        graphDemo.addEdges(0, 1, 1);
//        graphDemo.addEdges(0, 2, 1);
//        graphDemo.addEdges(1, 2, 1);
//        graphDemo.addEdges(1, 3, 1);
//        graphDemo.addEdges(1, 4, 1);

        graphDemo.addPoints("1");
        graphDemo.addPoints("2");
        graphDemo.addPoints("3");
        graphDemo.addPoints("4");
        graphDemo.addPoints("5");
        graphDemo.addPoints("6");
        graphDemo.addPoints("7");
        graphDemo.addPoints("8");

        graphDemo.addEdges(0, 1, 1);
        graphDemo.addEdges(0, 2, 1);
        graphDemo.addEdges(1, 3, 1);
        graphDemo.addEdges(1, 4, 1);
        graphDemo.addEdges(2, 5, 1);
        graphDemo.addEdges(2, 6, 1);
        graphDemo.addEdges(3, 7, 1);
        graphDemo.addEdges(4, 7, 1);
        graphDemo.addEdges(5, 6, 1);

        graphDemo.show();

//        graphDemo.dfs();
        graphDemo.bfs();
    }
}
