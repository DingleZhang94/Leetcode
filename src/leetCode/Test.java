package leetCode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Test {
	public static void main(String[] args) {
		MinStack stack = new MinStack();
		stack.push(-2);
		stack.push(0);
		stack.push(-3);
		// System.out.println(stack.getMin());
		PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer a, Integer b) {
				return a > b ? -1 : 1;
			}
		});
		queue.add(1);
		queue.add(2);
		queue.add(-1);
		queue.add(0);
		System.out.println(queue.poll());
	}
}
