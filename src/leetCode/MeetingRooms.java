package leetCode;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRooms {
	public boolean canAttendMeetings(int[][] intervals) {
		// Write your solution here
		Arrays.sort(intervals, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[0] - o2[0];
			}
		});
		for (int i = 0; i < intervals.length - 1; i++) {
			if (intervals[i][1] > intervals[i + 1][0]) {
				return false;
			}
		}
		return true;
	}

	public void sort(int[][] arr, int left, int right) {
		if (left < right) {
			int pivot = partition(arr, left, right);
			sort(arr, left, pivot - 1);
			sort(arr, pivot + 1, right);
		}
	}

	private int partition(int[][] arr, int left, int right) {
		int pivot = left;
		int i = left + 1;
		int j = right;
		while (true) {
			while (i <= j && arr[i][0] < arr[pivot][0]) {
				i++;
			}
			while (i <= j && arr[j][0] >= arr[pivot][0]) {
				j--;
			}
			if (i > j)
				break;
			int[] temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			System.out.println("i: " + i + " j: " + j);
		}
		int[] temp = arr[j];
		arr[j] = arr[pivot];
		arr[pivot] = temp;
		return j;
	}

	public void show(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}

	}

	public static void main(String[] args) {
		MeetingRooms meetingRooms = new MeetingRooms();
		int[][] a = { { 12, 20 }, { 20, 30 }, { 30, 35 }, { 35, 120 } };
		meetingRooms.sort(a, 0, a.length - 1);
		meetingRooms.show(a);
		System.out.println(meetingRooms.canAttendMeetings(a));
	}
}
