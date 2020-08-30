package ladder.domain.ladder;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Name {

	private static final int NAME_MAX_LENGTH = 5;

	private final String name;

	private Name(String name) {
		String trimName = name.trim();
		if (trimName.length() > NAME_MAX_LENGTH) {
			throw new IllegalArgumentException(String.format("이름은 %d글자 이내로 입력해주세요.", NAME_MAX_LENGTH));
		}
		this.name = trimName;
	}

	public static Name of(String name) {
		return new Name(name);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
