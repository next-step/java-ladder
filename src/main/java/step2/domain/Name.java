package step2.domain;

import java.util.Objects;

import step2.util.Validator;

public class Name {

	private final String value;

	public Name(String input) {
		Validator.notBlank(input);
		validateNameLength(input);
		this.value = input;
	}

	private void validateNameLength(String input) {
		if (input.length() > 5) {
			throw new IllegalArgumentException("이름이 5글자를 초과합니다.");
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Name name = (Name)o;
		return Objects.equals(value, name.value);
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}
}
