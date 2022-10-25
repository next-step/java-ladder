package ladder.domain;

/**
 * Created by seungwoo.song on 2022-10-17
 */
public class Person {

	public static final int MAX_LENGTH_NAME = 5;

	private String name;
	private int position;

	public Person(String name) {
		this(name, 0);
	}

	public Person(String name, int position) {
		if (name.length() > MAX_LENGTH_NAME) {
			throw new IllegalArgumentException("이름은 5글자 이하여야 합니다.");
		}

		this.name = name;
		this.position = position;
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}

	public boolean isSameName(String name) {
		return this.name.equals(name);
	}
}
