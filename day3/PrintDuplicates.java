package week2.day3;

import java.util.Arrays;

public class PrintDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// declaring the array of integers
		int[] num = { 2, 5, 7, 7, 5, 9, 2, 3 };
		// sorting the array
		Arrays.sort(num);
		for (int i = 0; i<num.length- 1; i++) {

			if (num[i]==num[i + 1])
			{
				System.out.println(num[i]);
			}
			
		}
	}

}
