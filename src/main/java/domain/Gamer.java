package domain;

import com.google.common.base.Preconditions;

/**
 * Created by hspark on 16/11/2018.
 */
public class Gamer {
	public static final int MAX_GAMER_NAME_LENGTH = 5;

	private String name;
	private Point point;

	public Gamer(String name, int position) {
		Preconditions.checkArgument(name.length() <= MAX_GAMER_NAME_LENGTH, "이름이 너무 깁니다.");
		this.name = name;
		this.point = new Point(position);
	}

	public String getName() {
		return name;
	}

	public boolean isPassable(LadderLine ladderLine) {
		return ladderLine.isPassable(this.point);
	}

	public void passLine2(LadderLine ladderLine) {
		this.point = ladderLine.getMovePosition(this.point);
	}

	public Point getPoint() {
		return point;
	}
}
