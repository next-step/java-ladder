package ladder.model;

import java.util.Objects;

import ladder.message.ErrorMessage;

public class Name {

	private static final int LIMIT_LENGTH = 6;
	private final String name;

	public Name(String name) {
		checkNull(name);
		checkEmptyName(name);
		checkNameLimitLength(name);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public boolean isExist(String name) {
		return this.name.equals(name);
	}

	private void checkNull(String name) {
		if (name == null) {
			throw new IllegalArgumentException(ErrorMessage.NULL_ERROR_MESSAGE);
		}
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

}
