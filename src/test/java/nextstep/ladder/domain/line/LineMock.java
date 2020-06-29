package nextstep.ladder.domain.line;

import nextstep.ladder.domain.point.Points;

public class LineMock extends Line {

	private LineMock(Points points) {
		super.points = points;
	}

	public static LineMock ofPoints(Points points) {
		return new LineMock(points);
	}

	@Override
	public Points getPoints() {
		return super.points;
	}
}
