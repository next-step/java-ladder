package nextstep.ladder.domain.ladder;

import java.util.HashMap;
import java.util.List;

import nextstep.ladder.exception.BadRequestException;

public class Results {

	private final List<String> results;
	private HashMap<String, String> resultMap = new HashMap<>();

	public Results(int participantsSize, List<String> results) {
		validateIsEmpty(results);
		validateSize(participantsSize, results);
		this.results = results;
	}

	public String get(String name) {
		return resultMap.get(name);
	}

	public void put(String name, int resultIndex) {
		if (!resultMap.containsKey(name)) {
			resultMap.put(name, results.get(resultIndex));
		}
	}

	public boolean isDone() {
		return resultMap.size() == results.size();
	}

	public List<String> getResults() {
		return this.results;
	}

	public void validateIsEmpty(List<String> names) {
		if (names.isEmpty()) {
			throw new BadRequestException("결과는 공백일 수 없습니다.");
		}
	}

	public void validateSize(int participantsSize, List<String> results) {
		if (results.size() != participantsSize) {
			throw new BadRequestException("결과의 수가 참여자 수와 같지 않습니다.");
		}
	}
}
