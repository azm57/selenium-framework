package programs;

public class First100Prime {

	public static void main(String[] args) {
		int primecount = 0;
		for(int i=2;i<600;i++) {
			int count = 0;
			for(int j=i;j>0;j--) {
				if(i%j==0)count++;
			}
			if(count==2) { if(primecount<25)primecount++;else break;System.out.println(i+" "); }
		}
	}
}
