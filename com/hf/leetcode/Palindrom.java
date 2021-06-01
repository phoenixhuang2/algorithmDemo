package com.hf.leetcode;

import java.util.ArrayList;

public class Palindrom {
    public boolean isPalindrom(int x) {
        int flag = 0;
        ArrayList<Integer> modRes = new ArrayList<>();
        while (x > 0 || x == 0) {
            flag = x%10;
            modRes.add(flag);
            x = x/10;
            if (x == 0) {
                break;
            }
        }
        if (modRes.size() == 0) {
            return false;
        }
        for (int i=0; i<modRes.size()/2; i++) {
            if (modRes.get(i) != modRes.get(modRes.size()-1-i)) {
                return false;
            }
        }
        return true;
    }

    /**
     *
     * @param x
     * @return
     */
    public boolean isPalindromV2(int x) {
        int count = 0;
        int flag = x;
        while (x > 0 || x == 0) {
            x = x/10;
            count++;
            if (x==0) {
                break;
            }
        }
        if (count == 0) {
            return false;
        }
        int i =1;
        while (i <= count) {

        }
        return true;
    }

    public static void main(String[] args) {
        Palindrom obj = new Palindrom();
        boolean result = obj.isPalindromV2(1001);
        System.out.println(result);
    }
}
