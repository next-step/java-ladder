package ladder.model;

import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import ladder.message.ErrorMessage;

public class Name {

	public static final String SPACE_NAME = " ";
	private static final int LIMIT_LENGTH = 6;
	private final String name;

	public Name(String name) {
		checkEmptyName(name);
		checkNameLimitLength(name);
		this.name = name;
	}

	private void checkEmptyName(String name) {
		if (name.isEmpty()) {
			throw new IllegalArgumentException(ErrorMessage.EMPTY_ERROR_MESSAGE);
		}
	}

	private void checkNameLimitLength(String name) {
		if (name.length() >= LIMIT_LENGTH) {
			throw new IllegalArgumentException(ErrorMessage.LIMIT_LENGTH_MESSAGE);
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Name name1 = (Name)o;
		return Objects.equals(name, name1.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public String toString() {
		return Stream.generate(() -> SPACE_NAME)
			.limit(LIMIT_LENGTH - name.length())
			.collect(Collectors.joining()).concat(name);
	}
}
