package No2;

public class AddTwoNumbers {
	public ListNode solution(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(0);
		ListNode prehead = head;
		int sum = 0;
		while (l1 != null || l2 != null) {
			sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + sum;
			l1 = (l1 == null ? l1 : l1.next);
			l2 = (l2 == null ? l2 : l2.next);
			head.next = new ListNode(sum % 10);
			head = head.next;
			sum = sum / 10;
			if (sum != 0) {
				head.next = new ListNode(1);
			}
		}
		return prehead.next;
	}
}
