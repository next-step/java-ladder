package nextstep.ladder.domain.point;

import java.util.List;

import nextstep.ladder.domain.player.Position;

public class Points {

	private final List<Point> points;

	private Points(List<Point> pointsList) {
		this.points = pointsList;
	}

	public static Points ofPoints(List<Point> pointsList) {
		// validateLastPointNotConnected(pointsList);
		validateNotConnectedContinuously(pointsList);
		return new Points(pointsList);
	}

	// private static void validateLastPointNotConnected(List<Point> pointList) {
	// 	Point lastPoint = pointList.stream()
	// 		.reduce((first, second) -> second)
	// 		.orElseThrow(() -> new IllegalArgumentException("why last point is null?"));
	// 	lastPoint.validateNotConnectedIfLastPoint();
	// }

	private static void validateNotConnectedContinuously(List<Point> pointList) {
		pointList.stream()
			.reduce((lastElement, nextElement) -> {
				if (lastElement.canMoveRight() && nextElement.canMoveRight()) {
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

	public Position movePosition(Position givenPosition) {
		if (canMoveRight(givenPosition)) {
			return givenPosition.moveOneStepFurther();
		}
		if (canMoveLeft(givenPosition)) {
			return givenPosition.moveOneStepBack();
		}
		return givenPosition;
	}

	private void validateGivenPosition(int givenPosition) {
		if (givenPosition >= points.size()) {
			throw new IllegalArgumentException("your given position is out of bound to current list indexes.");
		}
	}

	private boolean canMoveRight(int givenPosition) {
		return points.get(givenPosition).canMoveRight();
	}

	private boolean canMoveLeft(int givenPosition) {
		int beforeGivenPosition = givenPosition - 1;
		return givenPosition > 0 && points.get(beforeGivenPosition).canMoveRight();
	}

	private boolean canMoveRight(Position givenPosition) {
		return points.get(givenPosition.getPosition()).canMoveRight();
	}

	private boolean canMoveLeft(Position givenPosition) {
		int currentPosition = givenPosition.getPosition();
		return currentPosition > 0 && points.get(currentPosition).canMoveLeft();
	}

	public String printPoints() {
		StringBuilder builder = new StringBuilder();
		points.forEach(point -> {
			builder.append("|");
			builder.append(String.format("%-5s", point.canMoveRight() ? "-----" : ""));
		});
		return builder.toString();
	}
}
