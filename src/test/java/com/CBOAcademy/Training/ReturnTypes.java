package com.CBOAcademy.Training;

public class ReturnTypes {

	//The return type of a method should be compatible with return type specified in a method
	public int add() { 
	      int x = 10;
	      int y = 50;
	      int z = x+y;
	      System.out.println("Method with return type as int datatype:" +z );
	      return z;
	   }

	//if you declare a method with Boolean and return type should not be int
	public int add1() { 
	      int x1 = 10;
	      int y1 = 50;
	      int z = x1+y1 ;
	      System.out.println(z);
	      return z;
	   }
	
	// return type as Void
	public  void example(){
		
		int x =5;
		int y =4;
		int z = x+y;
		System.out.println("return type as void");
		//return x+y;
		
	}

	//parameters can be passed in a sequence and they must be 
	//accepted by the method in the same sequence
	public double add(double x, int y) { 
	      double z = x+y;
	      System.out.println("Method with two arguments :" +z);
	      return z;
	   }

	
	//Return type as non-primtive data type as String
		public String string1(){
			String text = "Method with return type as String";
			System.out.println(text);
			return text;
			
		}
	
	//return type Non-primitve data type as Array
	public static int[] returnArray()  
	{  
	int a1=20;  
	int a2=23;  
	int a3=87;  
	System.out.println("Method with return type as Array");
	return new int[] {a1,a2,a3};     
	} 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReturnTypes r = new ReturnTypes();
		r.add();
		r.add1();
		//r.add(1, 1.5);
		r.add(1.5, 1);
	returnArray();
	r.string1();
	r.example();
	
 
	}

}
