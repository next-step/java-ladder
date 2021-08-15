package ladder.model;

import java.util.Objects;
import ladder.dto.NameDto;
import ladder.message.ErrorMessage;

public class Name {

	private static final int LIMIT_LENGTH = 6;
	private final String name;

	public Name(String name) {
		checkEmptyName(name);
		checkNameLimitLength(name);
		this.name = name;
	}

	public String getName() {
		return NameDto.of(name).value();
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
