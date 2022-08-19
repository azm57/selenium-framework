package programs;

public class Factorial {

	public static void main(String[] args) {
		int num = 7;
		int fact = 1;
		if(num == 0) {System.out.println("1");}
		else if(num < 0) {System.out.println("factorial not defined");}
		else
		{
			while(num>0) {
				fact = fact * num;
				num = num - 1;
			}
			System.out.println(fact);
		}
	}
}