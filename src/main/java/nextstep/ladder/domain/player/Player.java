package nextstep.ladder.domain.player;

import java.util.Objects;

public class Player {

	private static final int MAXIMUM_NAME_LENGTH = 5;
	private String name;
	private Position currentPosition;

	private Player(String name, Position position) {
		this.name = name;
		this.currentPosition = position;
	}

	public static Player ofNameAndPositionAndSize(String name, int position, int size) {
		validateNotNull(name);
		validateNameLength(name);
		Position currentPosition = Position.ofPosition(position, size);
		return new Player(name, currentPosition);
	}

	private static void validateNotNull(String name) {
		if (Objects.isNull(name) || name.trim().isEmpty()) {
			throw new IllegalArgumentException("이름은 null 또는 빈 공백일 수 없습니다.");
		}
	}

	private static void validateNameLength(String name) {
		if (name.length() > MAXIMUM_NAME_LENGTH) {
			throw new IllegalArgumentException("이름의 최대 길이는 5자입니다.");
		}
	}

	public Position updateCurrentPosition(Position position) {
		this.currentPosition.updatePosition(position);
		return this.currentPosition;
	}

	public boolean validateCurrentPosition(int size) {
		return this.currentPosition.validatePosition(size);
	}

	public String getName() {
		return name;
	}

	public Position getCurrentPosition() {
		return currentPosition;
	}
}
