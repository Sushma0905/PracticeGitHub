package Java.Practice.Questions;

public class superKeywordChild extends superKeywordParent{
	int a;
	public  superKeywordChild(){
		super("String");
		this.a=5;
		System.out.println("Child class");
		System.out.println(this.a);
	}

	public static void main(StringExcercises[] args) {
		// TODO Auto-generated method stub
		superKeywordChild ch = new superKeywordChild();
		//ch.b();
	}

}
