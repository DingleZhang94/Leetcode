package leetCode;

public class BestTimeStock {
	public int maxProfit(int[] prices) {
		if (prices.length == 0) {
			return 0;
		}
		int min = prices[0];
		int maxProfit = 0;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] <= min) {
				continue;
			} else {
				maxProfit = Math.max(maxProfit, prices[i] - min);
				min = prices[i];
			}
		}
		return maxProfit;
	}
}
