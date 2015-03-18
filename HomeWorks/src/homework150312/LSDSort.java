package homework150312;

import java.util.Arrays;
import java.util.Random;

public class LSDSort {

	private static final int MAX = 1000000;

	public static void main(String[] args) {

		int[] data = generate(MAX, MAX);

//		int[] data1 = {0,0,4,4,4,3,2,2,1,2,2}; 
//		keyindex(data1);
		
		long start = System.currentTimeMillis();
		Arrays.sort(data);
		long stop = System.currentTimeMillis();
		System.out.println("Elapsed time for Arrays.sort= " + (stop - start));
		System.out.println();
		
		long start1 = System.currentTimeMillis();
		mysort(data);
		long stop1 = System.currentTimeMillis();
		System.out.println("Elapsed time for LSD Sort= " + (stop1 - start1));

//		for (int i=0; i<data.length;i++)
//			System.out.println(data[i]);
	
	}

	private static int[] generate(int r,int m) {
		int[] data = new int[r];

		Random random = new Random();

		for (int i = 0; i < data.length; i++) {
			data[i] = random.nextInt(m); // 0 - 999999
		}
		return data;
	}

	public static void mysort(int[] a) {
		
		int R = 256;
		int W= 4;
		int N = a.length;
		int[] aux = new int[N];
		for (int d = 0; d < W - 1; d++) {
			int[] count = new int[R + 1];
			for (int i = 0; i < N; i++)
				count[((a[i] >> d*8) & 0xFF) + 1]++;
			for (int r = 0; r < R; r++)
				count[r + 1] += count[r];
			for (int i = 0; i < N; i++)
				aux[count[(a[i] >> d*8) & 0xFF]++] = a[i];
			for (int i = 0; i < N; i++)
				a[i] = aux[i];
		}
		
	}
	
	public static void keyindex(int [] a){
		int N = a.length;
		int R=5;
		int[] aux = new int[N];
		int[] count = new int[R+1];
		for (int i = 0; i < N; i++)
		count[a[i]+1]++;
		for (int r = 0; r < R; r++)
		count[r+1] += count[r];
		for (int i = 0; i < N; i++)
		aux[count[a[i]]++] = a[i];
		for (int i = 0; i < N; i++)
		a[i] = aux[i];
	}
		
}
