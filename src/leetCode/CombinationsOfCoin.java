package leetCode;

import java.util.ArrayList;
import java.util.List;

public class CombinationsOfCoin {

	public List<List<Integer>> combinations(int target, int[] coins) {
		List<List<Integer>> res = new ArrayList<>();
		helper(res, new ArrayList<Integer>(), coins, target);
		return res;
	}

	private void helper(List<List<Integer>> res, List<Integer> combination, int[] coins, int remain) {
		System.out.println(combination);
		if (combination.size() == coins.length) {
			if (remain == 0)
				res.add(combination);
			return;
		}
		int val = coins[combination.size()];
		// if (remain < val)
		// return;
		for (int i = 0; i <= remain / val; i++) {
			List<Integer> newComb = new ArrayList<Integer>(combination);
			newComb.add(i);
			helper(res, newComb, coins, remain - i * val);
		}
	}

	public static void main(String[] args) {
		CombinationsOfCoin c = new CombinationsOfCoin();

		System.out.println(c.combinations(5, new int[] { 10, 5, 1 }));

	}

}
