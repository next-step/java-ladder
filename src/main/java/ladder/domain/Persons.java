package ladder.domain;

import ladder.util.StringUtil;

import java.util.*;

/**
 * Created by seungwoo.song on 2022-10-25
 */
public class Persons extends AbstractList<Person> {

	private final List<Person> persons;

	public Persons(List<Person> persons) {
		this.persons = persons;
	}

	public static Persons of(List<Person> list) {
		if (list == null || list.isEmpty()) {
			throw new IllegalArgumentException("값이 없습니다.");
		}

		return new Persons(list);
	}


	@Override
	public Person get(int index) {
		return persons.get(index);
	}

	public Person get(String name) {
		if (StringUtil.isBlank(name)) {
			throw new IllegalArgumentException("이름은 필수값 입니다");
		}

		return persons.stream()
			.filter(person -> person.isSameName(name))
			.findAny()
			.orElseThrow(() -> new IllegalArgumentException("잘못된 이름입니다. " + name));
	}

	@Override
	public int size() {
		return persons.size();
	}

	@Override public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Persons persons1 = (Persons)o;
		return Objects.equals(persons, persons1.persons);
	}

	@Override public int hashCode() {
		return Objects.hash(persons);
	}
}
