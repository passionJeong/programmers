package src.main.java;

import java.util.Arrays;

public class HIndex {
	public int solution(int[] citations) {
		int citCount = citations.length;
		int hIndex = 0;

		Arrays.sort(citations);

		for(int i = 0; i < citCount; i++) {
			if(citations[i] >= hIndex && (citCount - i) > hIndex) {
				hIndex = Math.min(citations[i], citCount - i);
			}
		}

		return hIndex;
	}
}
