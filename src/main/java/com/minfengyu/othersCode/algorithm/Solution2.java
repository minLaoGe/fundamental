package com.minfengyu.othersCode.algorithm;

import java.util.HashSet;

public class Solution2 {
    public static int maxProduct(String[] words){
        int max=0;
        for (int i = 0; i < words.length; i++) {
            String wd=words[i];
            HashSet<Character> characters = new HashSet<>();
            for (char c : wd.toCharArray()) {
                characters.add(c);
            }
            int word1Length=wd.length();

            for (int i1 = i; i1 < words.length; i1++) {
                String wd2=words[i1];
                char[] chars = wd2.toCharArray();
                int tem=0;
                for (int i2 = 0; i2 < chars.length; i2++) {
                    if (characters.contains(chars[i2])){
                        tem=0;
                        break;
                    }
                    tem++;
                }
                max= Math.max(word1Length * tem, max);
            }

        }
        return max;
    }

    public static void main(String[] args) {
        String[] strings = {"abcw", "foo", "bar", "fxyz","abcdef"};
        System.out.println(maxProduct(strings) );
    }
}

