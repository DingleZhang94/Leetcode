package leetCode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianTracker {
	PriorityQueue<Integer> minHeap;
	PriorityQueue<Integer> maxHeap;
	int counter;

	public MedianTracker() {
		minHeap = new PriorityQueue<>();
		maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer i, Integer j) {
				return i > j ? -1 : 1;
			}
		});
		counter = 0;
	}

	public void read(int value) {
		if (counter++ == 0) {
			maxHeap.offer(value);
			return;
		}

		// Add element in the following heap
		if (value <= maxHeap.peek()) {
			maxHeap.offer(value);
		} else {
			minHeap.offer(value);
		}

		// Re-balance the heap
		if (maxHeap.size() - minHeap.size() > 1) {
			minHeap.offer(maxHeap.poll());
		} else if (minHeap.size() > maxHeap.size()) {
			maxHeap.offer(minHeap.poll());
		}

		counter++;
	}

	public Double median() {
		if (counter > 0) {
			return minHeap.size() == maxHeap.size() ? minHeap.peek() / 2.0 + maxHeap.peek() / 2.0
					: maxHeap.peek() - 0.0;
		} else {
			return null;
		}
	}

	public static void main(String[] args) {
		MedianTracker m = new MedianTracker();
		m.read(1);
		m.read(2);
		System.out.println(m.median());
	}
}
