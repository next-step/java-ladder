package nextstep.ladder.domain.line;

import nextstep.ladder.domain.point.Points;

public class LineMock extends Line {

	private Points points;

	private LineMock(Points points) {
		this.points = points;
	}

	public static LineMock ofPoints(Points points) {
		return new LineMock(points);
	}

	@Override
	public Points getPoints() {
		return points;
	}
}
