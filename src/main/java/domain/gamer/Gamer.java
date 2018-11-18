package domain.gamer;

import com.google.common.base.Preconditions;
import domain.point.Point;

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
		this.point = Point.of(position);
	}

	public String getName() {
		return name;
	}

	public Point getPoint() {
		return point;
	}

	public boolean isEqualName(String gamerName) {
		return gamerName == this.name;
	}

	@Override
	public String toString() {
		return name;
	}
}
