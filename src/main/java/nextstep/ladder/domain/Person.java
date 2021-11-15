package nextstep.ladder.domain;

import java.util.Objects;

import nextstep.ladder.exception.PersonNameSizeException;

public class Person {
	public static final int SIZE_OF_NAME = 5;

	private final String name;

	private Person(String name) {
		validateName(name);
		this.name = name;
	}

	private void validateName(String name) {
		if (name.length() > 5) {
			throw new PersonNameSizeException();
		}
	}

	public static Person create(String name) {
		return new Person(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}

		Person person = (Person)obj;

		return Objects.equals(name, person.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
}
