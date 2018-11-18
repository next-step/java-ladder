package domain.reward;

import domain.point.Point;

/**
 * Created by hspark on 18/11/2018.
 */
public class Reward {
	private String name;
	private Point point;

	public Reward(String name, Point point) {
		this.name = name;
		this.point = point;
	}

	public boolean isEqualPoint(Point point) {
		return this.point.equals(point);
	}

	@Override
	public String toString() {
		return name;
	}
}
