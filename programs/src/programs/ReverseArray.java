package programs;

import java.util.Arrays;

public class ReverseArray {

	public static void main(String[] args) {
		int arr[] = {1,2,3,4,5};
		int rev[] = {0,0,0,0,0};
		int j = 0;
		System.out.println(Arrays.toString(arr));
		for(int i=arr.length-1;i>=0;i--)
		{
			rev[j] = arr[i];
			j++;
		}
		System.out.println(Arrays.toString(rev));

	}

}
