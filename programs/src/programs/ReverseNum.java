package programs;

public class ReverseNum {

	public static void main(String[] args) {
		int num = 2409;
		int reverse = 0;
		while(num > 0) {
			
			reverse = 10*reverse+num%10;
			num = num/10;
		}
		System.out.println(reverse);
	}

}
