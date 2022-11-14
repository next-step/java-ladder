package nextstep.ladder.domain.participant;

import java.util.List;

import nextstep.ladder.exception.BadRequestException;

public class Participants {

	private final List<String> names;

	public Participants(List<String> names) {
		validateIsEmpty(names);
		names.forEach(this::validateNameLength);
		this.names = names;
	}

	public int size() {
		return names.size();
	}

	public void validateIsEmpty(List<String> names) {
		if (names.isEmpty()) {
			throw new BadRequestException("이름은 공백일 수 없습니다.");
		}
	}

	public void validateNameLength(String name) {
		if (name == null || name.length() == 0 || name.length() > 5) {
			throw new BadRequestException("입력가능한 이름 글자수가 아닙니다.");
		}
	}

	public List<String> getNames() {
		return this.names;
	}

	public boolean hasName(String input) {
		return names.stream()
			.anyMatch(name -> name.equals(input));
	}

	public int indexOf(String name) {
		return names.indexOf(name);
	}
}
