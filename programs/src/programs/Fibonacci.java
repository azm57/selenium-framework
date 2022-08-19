package programs;

public class Fibonacci {

	public static void main(String[] args) {
		int n1 = 0, n2 = 1, num;
		int totalTerms = 10;
        System.out.print(n1 + " " +
                n2 + " ");
 
        for (int i = 2; i < totalTerms; i++) {
            num=n1 + n2;
            System.out.print(num + " ");
            n1 = n2;
            n2 = num;
        }	 
	}
}
