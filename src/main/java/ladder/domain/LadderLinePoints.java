package ladder.domain;

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
		if (canMoveToRight(points.size() - 1)) {
			throw new IllegalArgumentException("마지막 좌표는 다음 좌표와 연결될 수 없습니다.");
		}
	}

	private void validateNotContinuouslyConnected() {
		for (int i = 0; i < points.size(); i++) {
			validateNotContinuouslyConnected(i);
		}
	}

	private void validateNotContinuouslyConnected(int position) {
		if (canMoveToRight(position) && canMoveToLeft(position)) {
			throw new IllegalArgumentException("좌표는 연속으로 연결될 수 없습니다.");
		}
	}

	private void validateExistPosition(int position) {
		if (position >= points.size()) {
			throw new IllegalArgumentException("좌표 수보다 큰 위치는 존재하지 않습니다.");
		}
	}

	public int moveSideFrom(int position) {
		validateExistPosition(position);

		return canMoveToRight(position) ? position + 1
				: canMoveToLeft(position) ? position - 1
				: position;
	}

	private boolean canMoveToRight(int position) {
		return points.get(position).isConnectedToNextPoint();
	}

	private boolean canMoveToLeft(int position) {
		return position > 0 && points.get(position - 1).isConnectedToNextPoint();
	}

	public int size() {
		return points.size();
	}

	public List<LadderLinePoint> getContent() {
		return points;
	}
}
