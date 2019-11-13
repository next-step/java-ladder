package ladder.domain.point;

import ladder.domain.Direction;

import java.util.Optional;

public class LastPoint extends Point {

	@Override
	protected void connectWithPoint(Direction direction, Point point) {
		if (direction.equals(Direction.HORIZONTAL)) {
			throw new IllegalStateException("제일 마지막 점은 가로로 연결될 수 없습니다");
		}
	}

	@Override
	public Optional<String> getName() {
		throw new IllegalStateException("마지막 점은 이름이 없습니다");
	}

}
