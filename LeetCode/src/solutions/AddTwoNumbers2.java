package solutions;

/**
 * @Author: Nandi Ouyang 
 * @Date Apr 23, 2015
 *  You are given two linked lists representing two non-negative numbers. 
 *  The digits are stored in reverse order and each of their nodes contain a single digit.
 *  Add the two numbers and return it as a linked list.
 *  Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 *  Output: 7 -> 0 -> 8
 */
public class AddTwoNumbers2 {

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	};

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		// check parameter
		if (l1 == null || l2 == null)
			return null;

		ListNode re1 = l2;
		ListNode re2 = l1;

		// calculate
		// using another list to store the number
		ListNode returnList = new ListNode(0);
		ListNode tempHead = returnList;
		int signNum = 0;
		while (re1 != null || re2 != null) {
			int val1 = 0;
			int val2 = 0;

			if (re1 != null)
				val1 = re1.val;
			if (re2 != null)
				val2 = re2.val;

			int returnVal = val1 + val2 + signNum;
			signNum = returnVal / 10;
			returnVal = returnVal % 10;

			ListNode temp = new ListNode(returnVal);
			tempHead.next = temp;

			tempHead = tempHead.next;
			if (re1 != null)
				re1 = re1.next;
			if (re2 != null)
				re2 = re2.next;

		}

		// be careful the last significant number
		if (signNum == 1)
			tempHead.next = new ListNode(signNum);

		return returnList.next;
	}
}

