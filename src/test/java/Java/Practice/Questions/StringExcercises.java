package Java.Practice.Questions;

import java.util.Arrays;

public class StringExcercises {

	

	
	public static void main(java.lang.String[] args) {
		// TODO Auto-generated method stub
		String s1 = "Deepika";
		String s2 = "Deepika";
		String s3 = new String("Deepika");
		System.out.println(s1.equals(s2));
		System.out.println(s1.equals(s3));
		
		System.out.println(s1==s2);
		System.out.println(s1==s3);
		System.out.println(s1.compareTo(s2));
		System.out.println(s1.compareTo(s3));
		
		System.out.println(s1+s2);
		System.out.println(s2.concat(s1));
		System.out.println(s2);
		StringBuilder s4 = new StringBuilder("Deepika");
		StringBuilder s5 = new StringBuilder("Sushma");
		
		s4.append(s5);
		System.out.println(s4);
		
		 String s8 = "Hello";    //String 1  
	        String s9 = " World";    //String 2  
	        String s7 = String.join("/",s8,s9); 
	        //String 3 to store the result  
	            System.out.println(s7.toString()); 
	            
	            System.out.println(s1.substring(3));
	            System.out.println(s2.substring(2, 6));//epik
	            System.out.println(s2.subSequence(2, 6));
	            
	            String text= new String("Hello, My name is, Sachin");  
	            String[] sp=  text.split(",");
	            System.out.println(Arrays.toString(sp));
	            
	           System.out.println(String.valueOf(10).length());
	           
	           StringBuffer SB = new StringBuffer();
	           System.out.println(SB.capacity());
	           
	           StringBuffer SB1 = new StringBuffer("Deepika");
	           System.out.println(SB1.capacity());
	           System.out.println(SB1.length());
	           
	           StringBuffer SB2 = new StringBuffer(20);
	           System.out.println(SB2.capacity());
	           
	           System.out.println(SB1.replace(0, 2, "Sushma"));
	           System.out.println(SB1.replace(0, 0, "Sushma"));
	           
	           System.out.println(SB1.delete(0, 2));
	           System.out.println(SB1.deleteCharAt(3));
	           
	           System.out.println(SB.capacity());//default 16  
	           SB.append("Hello");  
	           System.out.println(SB.capacity());//now 16  
	           SB.append("java is my favourite language");  
	           System.out.println(SB.capacity());//now (16*2)+2=34 i.e (oldcapacity*2)+2  
	          SB.ensureCapacity(30);
	          System.out.println(SB.capacity());
	          
	           
	           
	}

}
