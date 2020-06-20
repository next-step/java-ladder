package nextstep.ladder.domain.point;

import java.util.List;

public class Points {

	private final List<Point> points;

	private Points(List<Point> pointsList) {
		this.points = pointsList;
	}

	public static Points ofPoints(List<Point> pointsList) {
		validateLastPointNotConnected(pointsList);
		validateNotConnectedContinuously(pointsList);
		return new Points(pointsList);
	}

	private static void validateLastPointNotConnected(List<Point> pointList) {
		Point lastPoint = pointList.stream()
			.reduce((first, second) -> second)
			.orElseThrow(() -> new IllegalArgumentException("why last point is null?"));
		lastPoint.validateNotConnectedIfLastPoint();
	}

	private static void validateNotConnectedContinuously(List<Point> pointList) {
		pointList.stream()
			.reduce((lastElement, nextElement) -> {
				if (lastElement.isConnectedToNextPoint() && nextElement.isConnectedToNextPoint()) {
					throw new IllegalArgumentException("illegal input that tries to connect points continuously.");
				}
				return nextElement;
			});
	}

	public List<Point> getPoints() {
		return points;
	}

	public int getSize() {
		return points.size();
	}

	public int movePosition(int givenPosition) {
		validateGivenPosition(givenPosition);
		if (canMoveRight(givenPosition)) {
			return givenPosition + 1;
		}
		if (canMoveLeft(givenPosition)) {
			return givenPosition - 1;
		}
		return givenPosition;
	}

	private void validateGivenPosition(int givenPosition) {
		if (givenPosition >= points.size()) {
			throw new IllegalArgumentException("your given position is out of bound to current list indexes.");
		}
	}

	private boolean canMoveRight(int givenPosition) {
		return points.get(givenPosition).isConnectedToNextPoint();
	}

	private boolean canMoveLeft(int givenPosition) {
		int beforeGivenPosition = givenPosition - 1;
		return givenPosition > 0 && points.get(beforeGivenPosition).isConnectedToNextPoint();
	}
}
