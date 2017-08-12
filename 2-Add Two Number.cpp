//2. Add Two Numbers(Unsolved)
/**
//熟悉ListNode(int x): val(x),next(NULL){}的赋值方法
//指针模拟数值进位
*/
#include <iostream>

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
	ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
		ListNode preHead(0);
		*p = &preHead;
		int extra = 0;
		while(l1 || l2 || extra){
			int sum = (l1 ? l1->val:0) + (l2 ? l2->val:0) + extra;
			extra = sum / 10;
			p ->next = ListNode(sum % 10);
			p = p ->next;
			
			l1 = l1 ? l1->next : l1;
			l2 = l2 ? l2->next : l2;
			
		}
		
		return preHead.next;
	}
};