package ladder.domain.point;

import ladder.domain.Direction;

public class LastPoint extends Point {

	private final String result;

	public LastPoint(String result) {
		this.result = result;
	}

	@Override
	protected void connectWithPoint(Direction direction, Point point) {
		if (direction.equals(Direction.HORIZONTAL)) {
			throw new IllegalStateException("제일 마지막 점은 가로로 연결될 수 없습니다");
		}
		throw new IllegalStateException("제일 마지막 점은 세로로 다음 점을 가질 수 없습니다");
	}

	@Override
	public String getName() {
		throw new IllegalStateException("마지막 점은 이름을 가질 수 없습니다");
	}

	@Override
	public String getResultFrom(Direction direction) {
		return result;
	}

}
