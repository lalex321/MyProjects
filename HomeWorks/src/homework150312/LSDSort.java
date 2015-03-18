package homework150312;

import java.util.Arrays;
import java.util.Random;

public class LSDSort {

	private static final int MAX = 1000000;

	public static void main(String[] args) {
		
		int[] data = generate();
				
		long start = System.currentTimeMillis();
//		Arrays.sort(data);
		
		sort1.mysort(data);
		
		long stop = System.currentTimeMillis();
		
		System.out.println("Elapsed = " + (stop - start));
	}

	private static int[] generate() {
		int[] data = new int[MAX];
		
		Random random = new Random();
		
		for (int i = 0; i < data.length; i++) {
			data[i] = random.nextInt(MAX); // 0 - 999999
		}
		
		return data;
	}
	



}

