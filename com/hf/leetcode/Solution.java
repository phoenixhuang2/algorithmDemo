package com.hf.leetcode;

class Solution {
    /**
     * 开辟了3个同等的空间
     * 时间复杂度O(n^2)
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        //切分单词
        String[] sRes = s.split(" ");
        String newRes = "";
        //反转
        for (int i=0; i < sRes.length; i++) {
            char[] words = sRes[i].toCharArray();
            for (int j=0; j< words.length/2; j++) {
                char temp = words[j];
                words[j] = words[words.length-1-j];
                words[words.length-1-j] = temp;
            }
            if (i != 0) {
                newRes += " ";
            }
            newRes += String.valueOf(words);
        }
        return newRes;
    }

    /**
     * 开辟一个同等大小的数组
     * @param
     * @return
     */
    public String reverseWordsV2(String s) {
        StringBuilder stringB = new StringBuilder();
        if (s.isEmpty()) {
            return s;
        }
        int start = 0;
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == ' ') {
                for (int j = i-1; j>=start; j--) {
                    char temp = s.charAt(j);
                    stringB.append(temp);
                }
                stringB.append(' ');
                start = i+1;
            }

            if (i == s.length() -1) {
                for (int j = i; j>=start; j--) {
                    char temp = s.charAt(j);
                    stringB.append(temp);
                }
            }

        }
        return stringB.toString();
    }

    public String reverseWordsV3(String s) {
        StringBuilder sRes = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            int start = i;
            while (i < s.length() && s.charAt(i) != ' ') {
                i++;
            }

            for (int j=i-1; j>=start; j--) {
                sRes.append(s.charAt(j));
            }

            if (i<s.length() && s.charAt(i) == ' ') {
                sRes.append(' ');
                i++;
            }
        }
        return sRes.toString();
    }
    public static void main(String[] args) {
        Solution obj = new Solution();
        String result = obj.reverseWordsV3("Let's take LeetCode contest");
        System.out.println(result);
    }
}
