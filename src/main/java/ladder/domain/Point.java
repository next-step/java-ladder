package ladder.domain;

import java.util.Objects;

/**
 * Created by seungwoo.song on 2022-11-01
 */
public class Point {

	private final int index;

	public Point(int index) {
		this.index = index;
	}

	public boolean move(Direction direction) {
		return false;
	}

	public int getIndex() {
		return index;
	}

	@Override public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Point point = (Point)o;
		return index == point.index;
	}

	@Override public int hashCode() {
		return Objects.hash(index);
	}
}
