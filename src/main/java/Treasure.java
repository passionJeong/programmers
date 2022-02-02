package src.main.java;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Treasure {
	public void treasure() {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Integer result = 0;

		try {
			Integer N = Integer.parseInt(br.readLine());
			Integer[] A = new Integer[N];
			Integer[] B = new Integer[N];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				B[i] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(A);
			Arrays.sort(B, Collections.reverseOrder());

			result = 0;

			for(int i = 0; i < N; i++ ) {
				result += A[i] * B[i];
			}

		} catch (IOException e) {
			System.out.println("IOException Occur!!");
		} finally {
			System.out.println(result);
		}
	}
}
