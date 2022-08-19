package programs;

public class SecondLargeInArray {

	public static void main(String[] args) {
		int[] inputArr = {117,4,6,5,2,3,1,0,155,-8};
		//find the max, min
		int max = inputArr[0];
		int min = inputArr[0];
		int secmax = inputArr[0];
		for(int i:inputArr) {
			if(max<i) {secmax=max;max=i;}
			if(min>i) min=i;
		}
		System.out.println("max secmax min >> "+max+" "+secmax+" "+min);

	}

}
