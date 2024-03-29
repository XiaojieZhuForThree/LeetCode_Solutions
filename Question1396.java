import java.util.*;

public class Question1396 {

	class UndergroundSystem {
		Map<Integer, String> start;
		Map<Integer, Integer> enter;
		Map<String, Integer> startEndTime;
		Map<String, Integer> startEndNum;

		public UndergroundSystem() {
			start = new HashMap<>();
			enter = new HashMap<>();
			startEndTime = new HashMap<>();
			startEndNum = new HashMap<>();
		}

		public void checkIn(int id, String stationName, int t) {
			start.put(id, stationName);
			enter.put(id, t);
		}

		public void checkOut(int id, String stationName, int t) {
			StringBuilder domain = new StringBuilder();
			domain.append(start.get(id));
			domain.append("-");
			domain.append(stationName);
			String dom = domain.toString();
			startEndTime.put(dom, startEndTime.getOrDefault(dom, 0) + t - enter.get(id));
			startEndNum.put(dom, startEndNum.getOrDefault(dom, 0) + 1);
		}

		public double getAverageTime(String startStation, String endStation) {
			StringBuilder domain = new StringBuilder();
			domain.append(startStation);
			domain.append("-");
			domain.append(endStation);
			String dom = domain.toString();
			int time = startEndTime.getOrDefault(dom, 0);
			int num = startEndNum.getOrDefault(dom, 1);
			return (double) time / num;
		}
	}

	/**
	 * Your UndergroundSystem object will be instantiated and called as such:
	 * UndergroundSystem obj = new UndergroundSystem();
	 * obj.checkIn(id,stationName,t); obj.checkOut(id,stationName,t); double param_3
	 * = obj.getAverageTime(startStation,endStation);
	 */
}
