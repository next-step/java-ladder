package ladder.domain;

/**
 * Created by seungwoo.song on 2022-10-17
 */
public class Person {

	public static final int MAX_LENGTH_NAME = 5;

	private final String name;
	private int position;

	public Person(String name) {
		if (name.length() > MAX_LENGTH_NAME) {
			throw new IllegalArgumentException("이름은 5글자 이하여야 합니다.");
		}

		this.name = name;
	}

	public Person(String name, int position) {
		this.name = name;
		this.position = position;
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}
}
