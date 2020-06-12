package ladder;

import java.util.Collections;
import java.util.List;

public class LadderLinePoints {

	private final List<LadderLinePoint> points;

	private LadderLinePoints(List<LadderLinePoint> points) {
		this.points = Collections.unmodifiableList(points);
		validate();
	}

	public static LadderLinePoints of(List<LadderLinePoint> points) {
		return new LadderLinePoints(points);
	}

	private void validate() {
		validateNotLastIsConnected();
		validateNotContinuouslyConnected();
	}

	private void validateNotLastIsConnected() {
		if (points.get(points.size() - 1).isConnectedToNextPoint()) {
			throw new IllegalArgumentException("마지막 좌표는 다음 좌표와 연결될 수 없습니다.");
		}
	}

	private void validateNotContinuouslyConnected() {
		for (int i = 0; i < points.size() - 1; i++) {
			validateNotContinuouslyConnected(points.get(i), points.get(i + 1));
		}
	}

	private void validateNotContinuouslyConnected(LadderLinePoint point, LadderLinePoint nextPoint) {
		if (point.isConnectedToNextPoint() && nextPoint.isConnectedToNextPoint()) {
			throw new IllegalArgumentException("좌표는 연속으로 연결될 수 없습니다.");
		}
	}

	public int size() {
		return points.size();
	}

	public List<LadderLinePoint> getContent() {
		return points;
	}
}
