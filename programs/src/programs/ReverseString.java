package programs;

public class ReverseString {

	public static void main(String[] args) {
		String str1 = "Hello Green World";
		String revstr = "";
		for(int i=str1.length()-1;i>=0;i--) {
			revstr = revstr + str1.charAt(i);
		}
		System.out.println(revstr);

	}

}
