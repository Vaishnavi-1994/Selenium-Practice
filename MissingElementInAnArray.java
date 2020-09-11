package week1.day2.classroom.arrays;

import java.util.Arrays;
import java.util.HashSet;

public class MissingElementInAnArray {

	public static void main(String[] args) {
		// Here is the input
		int[] arr = {1,2,3,4,7,6,8};
		int j=0;

		// Sort the array	
		Arrays.sort(arr);
		HashSet hs=new HashSet();

		//	loop through the array (start i from arr[0] till the length of the array)
		for(int i=0;i<arr.length;i++)
		{
			//	check if the iterator variable is not equal to the array values respectively
			
			if (j<arr.length && i==arr[j])
				
			{
				j++;
				}
				else
				{
				hs.add(i);
				}
				}
		//	print the number
				System.out.println(j);

	}

}
