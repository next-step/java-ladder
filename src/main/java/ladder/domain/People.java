package ladder.domain;

import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.stream.Collectors;

public final class People {
	private final List<Name> names;

	public People(final List<String> nameList) {
		validate(nameList);
		this.names = nameList.stream().map(Name::new).collect(Collectors.toList());
	}

	private void validate(final List<String> nameList) {
		if (nameList.size() < 2) {
			throw new InputMismatchException("사람은 두명 이상이어야 합니다.");
		}
	}

	public int count() {
		return names.size();
	}

	public List<Name> values() {
		return Collections.unmodifiableList(names);
	}
}
