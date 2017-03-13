package learning;

import java.util.ArrayList;

public class Unit10 {
	public int[] intUnit() {
		int[] intArray = { 1, 2, 3, 5, 7, 11, 13, 17, 19, 23, 27 };
		for (int i : intArray) {
			System.out.print(i + " ");
		}
		return intArray;

	}

	public ArrayList<Object> problem6() {
		ArrayList<Object> list = new ArrayList<>();
		list.add(32);
		list.add("This is a string.");
		list.add(Integer.valueOf(238));
		list.add(-410);
		list.add(null);
		return list;
	}
}
