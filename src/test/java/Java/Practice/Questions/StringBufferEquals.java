package Java.Practice.Questions;

public class StringBufferEquals {
	public static void main(java.lang.String[] args) {
	
	String s1 = "Deepika";
	String s2 = "Deepika";
	String s3 = new String("Deepika");
	System.out.println(s1.equals(s2));
	System.out.println(s1.equals(s3));
	
	System.out.println(s1==s2);
	System.out.println(s1==s3);
	System.out.println(s1.compareTo(s2));
	System.out.println(s1.compareTo(s3));
	System.out.println(s1.hashCode());
	System.out.println(s2.hashCode());
	System.out.println(s3.hashCode());
	
	
	StringBuilder s4 = new StringBuilder("Deepika");
	StringBuilder s5 = new StringBuilder("Deepika");
	System.out.println(s4.equals(s5));
	System.out.println(s4==s5);
	System.out.println(s4.hashCode());
	System.out.println(s5.hashCode());
	
	StringBuffer s6 = new StringBuffer("Deepika");
	StringBuffer s7 = new StringBuffer("Deepika");
	System.out.println(s6.equals(s7));
	System.out.println(s6==s7);
	System.out.println(s6.hashCode());
	System.out.println(s7.hashCode());
	
}
}