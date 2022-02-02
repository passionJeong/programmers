package src.main.java;

public class BestWorstLottoPrize {
	public int[] solution(int[] lottos, int[] win_nums) {
		int[] answer = new int[2];

		Integer zeroCount = 0;
		Integer equalNumCount = 0;

		for(int i : lottos) {

			if(i == 0) {
				zeroCount++;
			}

			for(int j : win_nums) {
				if(i == j) {
					equalNumCount++;
				}
			}
		}

		answer[0] = getRanking(zeroCount + equalNumCount);
		answer[1] = getRanking(equalNumCount);

		return answer;
	}

	public Integer getRanking(Integer winCount) {

		switch(winCount) {
			case 6:
				return 1;
			case 5:
				return 2;
			case 4:
				return 3;
			case 3:
				return 4;
			case 2:
				return 5;
			default:
				return 6;
		}

	}
}