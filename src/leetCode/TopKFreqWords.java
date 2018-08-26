package leetCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class TopKFreqWords {
	public List<String> topKFrequent(String[] words, int k) {
		HashMap<String, Integer> freq = new HashMap<>();
		// calculate the frequency
		for (String word : words) {
			freq.put(word, freq.getOrDefault(word, 0) + 1);
		}

		Set<Map.Entry<String, Integer>> entries = freq.entrySet();

		PriorityQueue<Map.Entry<String, Integer>> heap = new PriorityQueue<>(
				new Comparator<Map.Entry<String, Integer>>() {
					@Override
					public int compare(Map.Entry<String, Integer> n1, Map.Entry<String, Integer> n2) {
						return n1.getValue() == n2.getValue() ? n1.getValue() - n2.getValue()
								: n1.getKey().compareTo(n2.getKey());
					}
				});

		int count = 0;
		for (Map.Entry<String, Integer> entry : entries) {
			if (k > count++) {
				heap.offer(entry);
			} else {
				if (heap.peek().getValue() <= entry.getValue()) {
					heap.offer(entry);
					heap.poll();
				}
			}
		}

		String[] s = new String[heap.size()];

		for (int i = heap.size() - 1; i >= 0; i--) {
			s[i] = heap.poll().getKey();
		}

		return Arrays.asList(s);
	}

	public static void main(String[] args) {
		String[] s = { "the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is" };
		TopKFreqWords t = new TopKFreqWords();
		t.topKFrequent(s, 4);
	}
}
