package ladder.domain;

/**
 * Created by seungwoo.song on 2022-10-17
 */
public class Person {

	private final String name;

	public Person(String name) {
		if (name.length() > 5) {
			throw new IllegalArgumentException("이름은 5글자 이하여야 합니다.");
		}

		this.name = name;
	}

	public String getName() {
		return name;
	}
}
