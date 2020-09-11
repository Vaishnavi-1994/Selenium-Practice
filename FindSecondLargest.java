package week1.day2.classroom.arrays;

import java.util.Arrays;

public class FindSecondLargest {

	public static void main(String[] args) {

		// Here is the input
		int[] data = {3,2,11,4,6,7};
		
		/*
		 Pseudo Code:
		 1) Arrange the array in ascending order*/
		 Arrays.sort(data);
		 
		 //Ascending order print
		 System.out.println("The Ascending order");
		 for(int i =0; i<data.length;i++)
		 {
		
			 System.out.println(data[i]);
		 }
		 /*
		 2) Pick the 2nd element from the last and print it
		 */
		 System.out.println("The second largest number in Array is " +data[data.length-2]);
		
		
	}

	
}