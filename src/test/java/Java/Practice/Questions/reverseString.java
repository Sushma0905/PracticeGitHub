package Java.Practice.Questions;

public class reverseString {
	public static void main(String[] args) {
		String s = "Deepika";
		char[] t = s.toCharArray();
		System.out.println(t.length);
		for (int i = t.length - 1; i >= 0; i--) {
			System.out.println(i + "=" + t[i]);
		}
	}

}
