package programs;

public class PrimeNum {

	public static void main(String[] args) {
		int num = 30;
		int count = 0;
		
		if(num==1 || num == 2) {System.out.println("Prime");}
		else {
		for(int i=num;i>1;i--)
		{
			if(num%i==0) {count++;}
		}
		System.out.println(count);
		if(count>=2) {System.out.println("Not Prime");}
		else {System.out.println("Prime");}
	}}

}
