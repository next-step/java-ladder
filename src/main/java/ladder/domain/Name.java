package ladder.domain;

import java.util.Objects;

public class Name {

	private final String name;

	public Name(String name) {
		if (name.isBlank()) {
			throw new IllegalArgumentException("이름은 비어있을 수 없습니다.");
		}
		if (name.length() > Names.LENGTH_MAXIMUM) {
			throw new IllegalArgumentException(String.format("이름은 최대 %d자까지 가능합니다.", Names.LENGTH_MAXIMUM));
		}
		if (name.equals(ResultName.ALL_PARTICIPANTS)) {
			throw new IllegalArgumentException(String.format("이름은 %s로 입력할 수 없습니다.", ResultName.ALL_PARTICIPANTS));
		}
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Name name1 = (Name)o;
		return Objects.equals(name, name1.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
}
