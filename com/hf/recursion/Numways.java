package com.hf.recursion;

public class Numways {

    public int show(int n, int[][] relation, int k) {
        int[][] map = new int[n][n];
        for (int i=0; i< relation.length; i++) {
            map[relation[i][0]][relation[i][1]] = 1;
        }
        int count = 0;
        check(map, 0, n, count);

        return 0;
    }

    public int check(int[][] map, int value, int n, int count) {
        for (int i=0; i<map[0].length; i++) {
            if (map[value][i] == 1) {
                count++;
                if (i == n-1) {
                    return count;
                } else {
                    return check(map, i, n, count);
                }
            }
        }
        return count;
    }
}
