package homework150312;

public class sort1 {
	
	
	public static void mysort(int[] a) {
	
		int R = 256;
		int W= 4;
		int N = a.length;
		int[] aux = new int[N];
		for (int d = 0; d < W - 1; d++) {
			int[] count = new int[R + 1];
			for (int i = 0; i < N; i++)
				count[a[i] >> (d << 3) & 0xFF + 1]++;
			for (int r = 0; r < R; r++)
				count[r + 1] += count[r];
			for (int i = 0; i < N; i++)
				aux[count[a[i] >> (d << 3) & 0xFF]++] = a[i];
			for (int i = 0; i < N; i++)
				a[i] = aux[i];
		}
		
	}
	
}
