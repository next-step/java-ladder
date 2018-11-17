package domain;

import com.google.common.base.Preconditions;

/**
 * Created by hspark on 16/11/2018.
 */
public class Gamer {
	public static final int MAX_GAMER_NAME_LENGTH = 5;
	private String name;
	private int position;

	public Gamer(String name) {
		Preconditions.checkArgument(name.length() <= MAX_GAMER_NAME_LENGTH, "이름이 너무 깁니다.");
		this.name = name;
	}

	public Gamer(String name, int position) {
		this.name = name;
		this.position = position;
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}

	public boolean isPassable(LadderLine ladderLine) {
		return ladderLine.isPassable(this.position);
	}

	public void passLine(LadderLine ladderLine) {
		this.position = ladderLine.getMovePosition(this.position);
	}
}
