package kaprekar;

import java.util.Arrays;
// Checks 
public class kaptest {
	
	public static final int[] noTest = {1111,2222,3333,4444,5555,6666,7777,8888};
	
	public static void main(String[] args) {
		int passingCount = 0;
		for (int j = 1; j <= 9998; j++) {
			if (testable(j) && test(j)) {
				passingCount++;
			}
		}
		
		if (passingCount == 9990) {
			System.out.println("ALL PASS");
		} else {
			System.out.println("FAIL");
		}
		
	}
	
	
	public static boolean testable(int in) {
		for (int same : noTest) {
			if (same == in) {
				return false;
			}
		}
		return true;
	}
	public static boolean test(int number) {
		int oldNum;
		while (number != 6174) {
			oldNum = number;
			number = iteration(oldNum);
			
		}
		if (number == 6174) return true;
		return false;
	}
	
	public static int iteration(int num) {
		// separate digits
		int[] digits = new int[4];
		for (int i = 0; i < 4; i++) {
			digits[i] = num % 10;
			num = num / 10;
		}
		// sort digits
		Arrays.sort(digits);
		String asc = "";
		String desc = "";
		// order ascending and descending
		for (int s : digits) {
			asc += "" + s;
		}
		for (int t : digits) {
			desc = t + desc;
		}
		
		// parseInt
		int ascInt = Integer.parseInt(asc);
		int descInt = Integer.parseInt(desc);
		return descInt - ascInt;
	}
}
