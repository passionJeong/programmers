package src.main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class OpenChatroom {
	public String[] solution(String[] record) {
		String[] answer = {};
		ArrayList<String> chatHistory = new ArrayList<>();
		HashMap<String, String> userInfo = new HashMap<>();

		//Enter uid1234 Muzi
		//Leave uid1234
		//Enter uid1234 Prodo
		//Change uid4567 Ryan
		for(int i = 0; i < record.length; i++) {
			String[] splitHistory = record[i].split("\\s+");
			String event = splitHistory[0];
			String uid = splitHistory[1];

			if(event.equals("Enter")) {
				String nickName = splitHistory[2];
				userInfo.put(uid, nickName);
				chatHistory.add(uid + "님이 들어왔습니다.");
			} else if(event.equals("Leave")) {
				chatHistory.add(uid + "님이 나갔습니다.");
			} else {
				String nickName = splitHistory[2];
				userInfo.put(uid, nickName);
			}
		}

		answer = new String[chatHistory.size()];

		for(int i = 0; i < chatHistory.size(); i++) {
			answer[i] = changeUidToNickname(userInfo, chatHistory.get(i));
		}

		return answer;
	}

	public String changeUidToNickname(HashMap<String, String> userInfo, String chat) {
		String[] splitChat = chat.split("님이 ");
		String uid = splitChat[0];
		return chat.replace(uid, userInfo.get(uid));
	}
}
