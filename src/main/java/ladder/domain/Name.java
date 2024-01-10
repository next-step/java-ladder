package ladder.domain;

import java.util.InputMismatchException;
import java.util.Objects;

public class Name {
	private static final int MAX_LENGTH = 5;
	private final String value;

	public Name(String name) {
		validate(name);
		this.value = name;
	}

	private void validate(String name) {
		if (name.length() > MAX_LENGTH || name.isEmpty()) {
			throw new InputMismatchException("이름의 길이는 1-5사이로 입력해주세요.");
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Name name1 = (Name)o;
		return Objects.equals(value, name1.value);
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}

	@Override
	public String toString() {
		return value;
	}
}
