/*
 *   Creates a strong password
 */


package utils;

import java.util.ArrayList; 
import java.util.concurrent.ThreadLocalRandom;

public class Random_Number_Gen {
	
	private final int PASSWORD_STRENGTH = 20;
	private ArrayList<ArrayList> lists = new ArrayList<ArrayList>();
	private ArrayList<String> list;
	private String result;
 
	
	public String get()
	{
		Populate_List();
		result = Generate_Random_Num();
		 
		return  result;
	}
 
	private String Generate_Random_Num()
	{
		String temp_res = "";
		int max = lists.get(0).size(); 
		int pointer;
		
		for (int i=0; i<PASSWORD_STRENGTH; i++)
		{
			pointer = ThreadLocalRandom.current().nextInt(0, max);
			temp_res = temp_res + lists.get(i).get(pointer);
		}
		
		return temp_res;
		
	}
	
	private void Populate_List()
	{
		        //For all lists
				for (int i=0; i<PASSWORD_STRENGTH; i++)
				{
					list = new ArrayList<String>();
					
					//For all numbers
					for (int j=0; j< 10; j++)
					{
						list.add(Integer.toString(j));
					}
					
					//For all letters
					char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
					for (int j=0; j<alphabet.length; j++)
					{
						list.add(Character.toString(alphabet[j]));
					}
					
					//For all uppercase letters
					char[] uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
					for (int j=0; j<uppercase.length; j++)
					{
						list.add(Character.toString(uppercase[j]));
					}
					
					//For all special characters letters
					char[] special = "!@#$%^&*()_+=-<,>.?/;:'".toCharArray();
					for (int j=0; j<special.length; j++)
					{
						list.add(Character.toString(special[j]));
					}
					 
					lists.add(list);
				}
	}

}
