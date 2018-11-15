package laddergame.domain;

public class Player {

	public static final int MAX_NAME_LENGTH = 5;

	private String name;

	public Player(String name) {
		if(name.length() > MAX_NAME_LENGTH) {
			throw new IllegalArgumentException("플레이어명은 최대 5글자까지 가능합니다.");
		}
		this.name = name;
	}

	public String getFomattedName() {
		return String.format("%" + MAX_NAME_LENGTH + "s", name);
	}
}
