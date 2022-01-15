package Java.Practice.Questions;

import java.util.HashMap;

public class duplicateCharacters {
	public static void main(String[] args) {
	String s = "DeepikaSushma";
	
	char[] ch = s.toCharArray();
	System.out.println(ch);
	HashMap<Character,Integer> hm = new HashMap<Character, Integer>();
	for(char c :ch){
		System.out.println(c);
	}

}}
