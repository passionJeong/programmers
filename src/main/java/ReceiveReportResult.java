package src.main.java;

import java.util.ArrayList;
import java.util.HashMap;

public class ReceiveReportResult {
	public int[] solution(String[] id_list, String[] report, int k) {
		int[] answer = new int[id_list.length];

		for(int i = 0; i < answer.length; i++) {
			answer[i] = 0;
		}

		//target, reporthistory
		HashMap<String, ReportHistory> reportHistories = new HashMap<>();

		for(int i = 0; i < report.length; i++) {
			//"muzi frodo"
			String source = report[i].split("\\s+")[0];
			String target = report[i].split("\\s+")[1];

			if(reportHistories.containsKey(target)) {
				//신고당한 이력이 있을 경우
				reportHistories.get(target).report(source);
			} else {
				reportHistories.put(target, new ReportHistory());
				reportHistories.get(target).report(source);
			}

		}

		for(int i = 0; i < id_list.length; i++) {
			//정지처분이 되어야 할 경우

			if(reportHistories.containsKey(id_list[i]) && reportHistories.get(id_list[i]).getReportCount() >= k) {
				ArrayList<String> sourceIdList = reportHistories.get(id_list[i]).getSourceIdList();
				for(int j = 0; j < sourceIdList.size(); j++) {
					answer[findIdIndex(id_list, sourceIdList.get(j))] ++;
				}
			}
		}


		return answer;
	}

	public int findIdIndex(String[] id_list, String id) {
		for(int i = 0; i < id_list.length; i++) {
			if(id_list[i].equals(id)) {
				return i;
			}
		}

		return -1;
	}
}

class ReportHistory {
	private ArrayList<String> sourceIdList = new ArrayList<>();
	private Integer reportCount = 0;

	public ArrayList<String> getSourceIdList() {
		return sourceIdList;
	}

	public Integer getReportCount() {
		return reportCount;
	}

	public void report(String sourceId) {
		if(!sourceIdList.contains(sourceId)) {
			//신고한 이력이 없을경우
			sourceIdList.add(sourceId);
			reportCount++;
		} else {
			//신고한 이력이 있을 경우는 무시한다.
		}
	}
}