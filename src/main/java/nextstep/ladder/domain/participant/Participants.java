package nextstep.ladder.domain.participant;

import java.util.List;

import nextstep.ladder.exception.BadRequestException;

public class Participants {

	private final List<String> names;

	public Participants(List<String> names) {
		checkNames(names);
		names.forEach(this::checkName);
		this.names = names;
	}

	public int size() {
		return names.size();
	}

	public void checkNames(List<String> names) {
		if (names.isEmpty()) {
			throw new BadRequestException("이름은 공백일 수 없습니다.");
		}
	}

	public void checkName(String name) {
		if (name == null || name.length() == 0 || name.length() > 5) {
			throw new BadRequestException("입력가능한 이름 글자수가 아닙니다.");
		}
	}

	public List<String> getNames() {
		return this.names;
	}
}
