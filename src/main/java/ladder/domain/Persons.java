package ladder.domain;

import java.util.AbstractList;
import java.util.List;
import java.util.Objects;

/**
 * Created by seungwoo.song on 2022-10-25
 */
public class Persons extends AbstractList<Person> {

	private final List<Person> values;

	private Persons(List<Person> values) {
		this.values = values;
	}

	public static Persons of(List<Person> list) {
		if (list == null || list.isEmpty()) {
			throw new IllegalArgumentException("값이 없습니다.");
		}

		return new Persons(list);
	}

	public static Persons of(Person person) {
		return new Persons(List.of(person));
	}

	public Person get(String name) {
		return values.stream()
			.filter(person -> person.isSameName(name))
			.findAny()
			.orElseThrow(() -> new IllegalArgumentException("잘못된 이름입니다"));
	}

	@Override
	public Person get(int index) {
		return values.get(index);
	}

	@Override
	public int size() {
		return values.size();
	}

	@Override public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Persons persons1 = (Persons)o;
		return Objects.equals(values, persons1.values);
	}

	@Override public int hashCode() {
		return Objects.hash(values);
	}
}
