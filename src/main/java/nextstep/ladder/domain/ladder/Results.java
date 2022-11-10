package nextstep.ladder.domain.ladder;

import java.util.List;

import nextstep.ladder.exception.BadRequestException;

public class Results {

	private final List<String> results;

	public Results(int participantsSize, List<String> results) {
		validateIsEmpty(results);
		validateSize(participantsSize, results);
		this.results = results;
	}

	public String get(int index) {
		return results.get(index);
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

	public List<String> getResults() {
		return this.results;
	}
}
