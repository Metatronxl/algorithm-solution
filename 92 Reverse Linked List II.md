92. Reverse Linked List II

https://leetcode.com/problems/reverse-linked-list-ii/description/

- 主要思路

在遍历到(m,n)的时候，新建一个链表，按照逆序的方式建立，然后在第二遍遍历(n,m)的时候，替换上新的链表



```Java
package com.example.demo.Algorithm;


import org.springframework.context.annotation.Bean;

import javax.xml.soap.Node;
import java.util.Arrays;


/**
 * @author lei.X
 * @date 2018/9/8
 */




public class Solution {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {

        ListNode reverList = new ListNode(0);
        ListNode HeadCur = head;
        int cur = 1;
        while (HeadCur != null){
            if (cur > n){ //不需要n后面的值
                break;
            }
            if (m<=cur && cur <= n){
                ListNode temp = new ListNode(HeadCur.val);
                temp.next = reverList;
                reverList = temp;
            }
            cur++;
            HeadCur = HeadCur.next;
        }

        int newCur = 1;
        ListNode myCur = head;
        while (myCur != null){
            if (m<=newCur && newCur <= n){
                myCur.val = reverList.val;
                reverList = reverList.next;
            }
            myCur = myCur.next;
            newCur++;
        }

        return head;
    }

    private static ListNode buildListNode(int[] num){

        ListNode resNode = new ListNode(num[0]);
        ListNode nodeCur = resNode;
        for (int i=1;i<num.length;i++){
            ListNode temp = new ListNode(num[i]);
            nodeCur.next = temp;
            nodeCur = nodeCur.next;
        }

        return resNode;
    }

    private static void printListNode(ListNode listNode){
        while (listNode!=null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        int[] example = new int[]{1,2,3,4,5};
        ListNode res = solution.buildListNode(example);
        ListNode result = solution.reverseBetween(res,2,3);


        printListNode(result);
    }
}
```

LeetCode思路：

图示：

![屏幕快照 2018-09-24 下午10.59.46](https://ws4.sinaimg.cn/large/006tNbRwly1fvl0xkqvouj30w80vijvs.jpg)





​	在遍历的同时更换链表指向

```Java
public ListNode reverseBetween(ListNode head, int m, int n) {
    if(head == null) return null;
    ListNode dummy = new ListNode(0); // create a dummy node to mark the head of this list
    dummy.next = head;
    ListNode pre = dummy; // make a pointer pre as a marker for the node before reversing
    for(int i = 0; i<m-1; i++) pre = pre.next;
    
    ListNode start = pre.next; // a pointer to the beginning of a sub-list that will be reversed
    ListNode then = start.next; // a pointer to a node that will be reversed
    
    // 1 - 2 -3 - 4 - 5 ; m=2; n =4 ---> pre = 1, start = 2, then = 3
    // dummy-> 1 -> 2 -> 3 -> 4 -> 5
    
    for(int i=0; i<n-m; i++)
    {
        //我们定义题中需要reversed的链表为needed_linkList
        start.next = then.next; //needed_linkList的第一个value指向不更换的第一个值
        then.next = pre.next;//needed_linkList的最后一个值指向开头
        pre.next = then;//设定原链表指向needed_linkList的第一个值为最后一个值
        then = start.next;//把整个链表给接上
    }
    
    // first reversing : dummy->1 - 3 - 2 - 4 - 5; pre = 1, start = 2, then = 4
    // second reversing: dummy->1 - 4 - 3 - 2 - 5; pre = 1, start = 2, then = 5 (finish)
    
    return dummy.next;
    
}
```