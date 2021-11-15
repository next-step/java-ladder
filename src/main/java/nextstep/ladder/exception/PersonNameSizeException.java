package nextstep.ladder.exception;

import nextstep.ladder.domain.Person;

@SuppressWarnings("serial")
public class PersonNameSizeException extends IllegalArgumentException {
	public PersonNameSizeException() {
		super(String.format("Person name 은 최대 %d자리 까지만 가능합니다.", Person.SIZE_OF_NAME));
	}
}
