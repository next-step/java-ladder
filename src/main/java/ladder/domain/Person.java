package ladder.domain;

/**
 * Created by seungwoo.song on 2022-10-17
 */
public class Person {

	public static final int MAX_LENGTH_NAME = 5;
	public static final int MOVE_DISTANCE = 2;

	private String name;
	private int position;

	public Person(String name) {
		this(name, 0);
	}

	public Person(String name, int index) {
		if (name.length() > MAX_LENGTH_NAME) {
			throw new IllegalArgumentException("이름은 5글자 이하여야 합니다.");
		}

		this.name = name;
		this.position = getPosition(index);
	}

	private int getPosition(int index) {
		return index * 2;
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

	public void moveLeft() {
		position -= MOVE_DISTANCE;
	}

	public void moveRight() {
		position += MOVE_DISTANCE;
	}

	@Override public String toString() {
		return "Person{" +
			"name='" + name + '\'' +
			", position=" + position +
			'}';
	}
}
