# LeetCodePractice 2018-09-21 #
- Greedy Test: Is Subsequence
- [https://leetcode.com/problems/is-subsequence/description/](https://leetcode.com/problems/is-subsequence/description/)



```Java

class Solution {
    public boolean isSubsequence(String s, String t) {
        char[] tArray = t.toCharArray();
        char[] sArray = s.toCharArray();
        int tLen = tArray.length;
        int sLen = sArray.length;
        int i=0,j=0;

        while (i<sLen){

            boolean judge = false;
            while (j<tLen){
                if (tArray[j] == sArray[i]){
                    judge = true;
                    j++;
                    break;
                }
                j++;
            }
            if (judge){
                i++;
            }else{
                return false;
            }
        }

        return true;
    }
}
```

