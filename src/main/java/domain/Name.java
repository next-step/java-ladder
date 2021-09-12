package domain;

import java.util.Objects;

public class Name {

	public static final Integer NAME_INIT_LENGTH = 5;
	private String name;

	public Name(String name) {
		if (name.length() > NAME_INIT_LENGTH) {
			throw new IllegalArgumentException("부여된 이름의 길이가 초과하였습니다.");
		}
		this.name = name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Name name1 = (Name) o;
		return Objects.equals(name, name1.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
}
