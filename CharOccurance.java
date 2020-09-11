package week1.day2.classroom.string;

import static org.testng.AssertJUnit.assertEquals;

public class CharOccurance {
	
	public static void main(String[] args) {
		// Check number of occurrences of a char (eg 'e') in a String
		
				String str = "welcome to chennai";
				char find='e';
				

				// declare and initialize a variable count to store the number of occurrences
				int count=0;
			
				// convert the string into char array
			
				
				
		/*
		 * for (char c : charArray) { System.out.println(c); } //get the length of the
		 * array
		 */				System.out.println(count);
		
				// traverse from 0 till the array length 
		 int i = 0;
				for(i=0;i<str.length()-1;i++)
				{	
				char ch=str.charAt(i);
				
				if(find==ch)	
				{
				count++;
				}
				}
				System.out.println(count);
					
				// print the count out of the loop
					
	}

}