package src.main.java;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MoreHot {
	public int solution(int[] scoville, int K) {
		int answer = 0;
		Arrays.sort(scoville);
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

		for(int scovilleCount : scoville) {
			priorityQueue.offer(scovilleCount);
		}

		while(priorityQueue.peek() < K) {
			if(priorityQueue.size() > 1) {
				priorityQueue.offer(shakeWithScoville(priorityQueue.poll(), priorityQueue.poll()));
				answer++;
			} else {
				answer = -1;
				break;
			}
		}

		return answer;
	}

	//섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
	public int shakeWithScoville(int scoville1, int scoville2) {
		return scoville1 + (scoville2 * 2);
	}
}
