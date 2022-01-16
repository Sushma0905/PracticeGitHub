package com.CBOAcademy.Training;

public class AccessModifiers_Sample1 {
	
/*	String defaultText = "Default Text";
	public String publicText = "Public Text";
	private String privateText = "private Text";
	protected String protectedText= "protected Text";*/
public void publicText(){
	System.out.println("Public Text");
}

 static void staticText(){
	System.out.println("Static Text");
}
 
 static void staticText1(){
	System.out.println("Static Text");
}
 
private void priText(){
	System.out.println("Private Text");
}


 void defaultText(){
	System.out.println("Default Text");
}
 
 protected void protectedText(){
		System.out.println("Protected Text");
	}
 
 
	public static void main(String[] args) {
		AccessModifiers_Sample1 sample = new AccessModifiers_Sample1();
		sample.defaultText();
		sample.priText();
		sample.protectedText();
		sample.publicText();
		staticText();
		/*System.out.println(sample.defaultText);
		System.out.println(sample.publicText);
		System.out.println(sample.privateText);
		System.out.println(sample.protectedText);
*/	}
}
