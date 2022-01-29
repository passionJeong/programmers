package src.main.java;

import java.util.Queue;
import java.util.LinkedList;


public class TruckPassTheBridge {
	public int solution(int bridge_length, int weight, int[] truck_weights) {
		Integer time = 0; //진행된 시간
		Integer truckCount = 0; //다리위의 트럭 개수
		Integer truckIndex = 0; //다리위에 최종적으로 올라간 트럭의 번호
		Integer weightsOnBridge = 0; //다리위 트럭 무게 합

		Queue<Truck> bridgeQueue = new LinkedList<>();

		//1번 트럭 적재
		bridgeQueue.add(new Truck(0, truck_weights[0], 0));
		truckCount++;
		weightsOnBridge += truck_weights[0];

		//트럭인덱스(다리 위 올라가있는 트럭번호)가 트럭 총 개수보다 작을동안 반복
		while(truckIndex < truck_weights.length) {
			//시간 됐으면 건너게 됨
			if(!bridgeQueue.isEmpty() && time - bridgeQueue.peek().timeOnBridge >= bridge_length) {
				if(bridgeQueue.peek().getIndex() == truck_weights.length - 1) {
					break;
				}
				weightsOnBridge -= bridgeQueue.poll().getWeight();
				truckCount--;
			}

			//다리 위 올라가있는 트럭 개수가 최대 수용개수보다 작을 경우
			if(truckCount < bridge_length) {
				//더 올라갈 수 있는지 조건을 판단
				//현재 다리 무게 + 다음 트럭의 무게 < 다리가 버티는 무게
				if(truckIndex < truck_weights.length - 1 && weightsOnBridge + truck_weights[truckIndex + 1] <= weight) {
					bridgeQueue.add(new Truck(truckIndex + 1, truck_weights[truckIndex + 1], time));
					truckCount++;
					weightsOnBridge += truck_weights[truckIndex + 1];
					truckIndex++;
				}

				time++;
			} else {
				//시간만 보낸다
				time++;
			}

		}

		return time + 1;
	}

}

class Truck {
	Integer index;
	Integer weight;
	Integer timeOnBridge;

	public Truck(Integer index, Integer weight, Integer timeOnBridge) {
		this.index = index;
		this.weight = weight;
		this.timeOnBridge = timeOnBridge;
	}

	public Integer getIndex() {
		return index;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setTimeOnBridge(Integer time) {
		this.timeOnBridge = time;
	}

	public Integer getTimeOnBridge() {
		return timeOnBridge;
	}
}
