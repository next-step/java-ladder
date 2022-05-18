package step2.domain.player;

import java.util.Objects;

import step2.util.ErrorTarget;
import step2.util.Validator;

public class Name {

	private static final int MAX_NAME_LENGTH = 5;

	private final String value;

	public Name(String input) {
		Validator.notBlank(input, ErrorTarget.NAME_INPUT);
		Validator.max(MAX_NAME_LENGTH, input.length(),
			String.format("이름이 최대 길이는 %d 글자 입니다. 입력 : %s", MAX_NAME_LENGTH, input));
		this.value = input;
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

	@Override
	public String toString() {
		return value;
	}
}
