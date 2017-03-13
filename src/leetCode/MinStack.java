package leetCode;

import java.util.LinkedList;

class MinStack {
	LinkedList<Integer> list = new LinkedList<>();
	int min;
	int s = 0;
	int y = 0;

	public MinStack() {
	}

	public void push(int x) {
		list.addFirst(x);
		s++;
	}

	public int pop() {
		s++;
		return list.poll();
	}

	public int top() {
		return list.getFirst();
	}

	public int getMin() {
		System.out.println("s= " + s + " y= " + y);
		if (s == y) {
			return min;
		} else {
			System.out.println("cal");
			min = list.getFirst();
			for (Integer integer : list) {
				if (integer < min) {
					min = integer;
				}
			}
			return min;
		}
	}
}
