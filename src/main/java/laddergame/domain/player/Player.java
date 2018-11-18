package laddergame.domain.player;

import java.util.Objects;

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

	public boolean isSameName(String name) {
		return this.name.equals(name);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Player)) {
			return false;
		}
		Player player = (Player) o;
		return Objects.equals(name, player.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public String toString() {
		return name;
	}
}
