package nextstep.ladder.domain.participant;

import java.util.List;
import java.util.stream.Collectors;

import nextstep.ladder.exception.BadRequestException;

public class ParticipantsOrderByInput {

	private static String ALL = "all";
	private final List<String> names;

	public ParticipantsOrderByInput(List<String> names) {
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

	public List<String> getMatchedName(String input) {
		if (ALL.equals(input)) {
			return getNames();
		}
		return names.stream()
			.filter(name -> name.equals(input))
			.collect(Collectors.toList());
	}

	public int indexOf(String name) {
		return names.indexOf(name);
	}
}
