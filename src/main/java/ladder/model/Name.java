package ladder.model;

import java.util.Objects;

import ladder.message.ErrorMessage;

public class Name {

	private final String name;

	public Name(String name) {
		checkEmptyName(name);
		checkNameLimitLength(name);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	private void checkEmptyName(String name) {
		if (name.isEmpty()) {
			throw new IllegalArgumentException(ErrorMessage.CHECK_EMPTY_NAME);
		}
	}

	private void checkNameLimitLength(String name) {
		if (name.length() > 5) {
			throw new IllegalArgumentException(ErrorMessage.CHECK_NAME_LIMIT_LENGTH);
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
}
