package nextstep.step4.domain;

import java.util.HashMap;
import java.util.Map;

public class Result {

	private Map<Integer, Integer> result = new HashMap<>();

	public void put(int start, int destination) {
		result.put(start, destination);
	}

	public int of(int startPosition) {
		return result.get(startPosition);
	}

}
