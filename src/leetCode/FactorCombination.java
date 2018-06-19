package leetCode;

import java.util.ArrayList;
import java.util.List;

public class FactorCombination {
	public List<List<Integer>> combinations(int target) {
		// Write your solution here
		List<List<Integer>> combinations = new ArrayList<>();
		List<Integer> combination = new ArrayList<>();
		helper(combinations, combination, 2, target, target);
		showList(combinations);
		return combinations;
	}

	private List<Integer> helper(List<List<Integer>> combinations, List<Integer> combination, int start, int curTarget,
			int target) {

		List<Integer> curCombination = new ArrayList<>();

		if (curTarget != target) {
			List<Integer> builder = new ArrayList<>(combination);
			builder.add(curTarget);
			combinations.add(builder);
		}

		for (int i = start; i <= Math.pow(curTarget, 0.5); i++) {
			if (curTarget % i == 0) {
				List<Integer> preCombination = new ArrayList<>(combination);
				preCombination.add(i);
				curCombination.add(i);
				curCombination.addAll(helper(combinations, preCombination, i, curTarget / i, target));
			}
		}

		return curCombination;
	}

	public void showList(List<List<Integer>> list) {
		for (List<Integer> combination : list) {
			for (Integer integer : combination) {
				System.out.print(integer + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FactorCombination a = new FactorCombination();
		a.combinations(200);
	}

}
