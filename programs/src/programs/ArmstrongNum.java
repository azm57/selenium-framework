package programs;

public class ArmstrongNum {

	public static void main(String[] args) {
		int num = 153;
		int temp = num;
		int sum = 0;
		while(temp>0) {
			int m = temp%10;
			sum = sum + m*m*m;
			temp = temp/10;
		}
		if(num==sum)
			System.out.println("Yes");
		else
			System.out.println("No");
	}
}
