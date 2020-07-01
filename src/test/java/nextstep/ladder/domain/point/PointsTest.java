package nextstep.ladder.domain.point;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import nextstep.ladder.domain.direction.Direction;
import nextstep.ladder.domain.player.Position;

public class PointsTest {

	public static Stream<Arguments> 왼쪽으로_이동이_가능한_모음() {
		Points points = Points.ofPoints(Arrays.asList(
			Point.ofPoint(Direction.first(false)),
			Point.ofPoint(Direction.of(false, true)),
			Point.ofPoint(Direction.of(true, false)),
			Point.ofPoint(Direction.of(false, true)),
			Point.ofPoint(Direction.of(true, false)),
			Point.ofPoint(Direction.of(false, true)),
			Point.ofPoint(Direction.last(true))
		));

		return Stream.of(
			Arguments.of(
				points,
				Position.ofPosition(2, points.getSize()),
				Position.ofPosition(1, points.getSize())),
			Arguments.of(
				points,
				Position.ofPosition(4, points.getSize()),
				Position.ofPosition(3, points.getSize())),
			Arguments.of(
				points,
				Position.ofPosition(6, points.getSize()),
				Position.ofPosition(5, points.getSize()))
		);
	}

	public static Stream<Arguments> 오른쪽으로_이동이_가능한_모음() {
		Points points = Points.ofPoints(Arrays.asList(
			Point.ofPoint(Direction.first(false)),
			Point.ofPoint(Direction.of(false, true)),
			Point.ofPoint(Direction.of(true, false)),
			Point.ofPoint(Direction.of(false, true)),
			Point.ofPoint(Direction.of(true, false)),
			Point.ofPoint(Direction.of(false, true)),
			Point.ofPoint(Direction.last(true))
		));
		return Stream.of(
			Arguments.of(
				points,
				Position.ofPosition(1, points.getSize()),
				Position.ofPosition(2, points.getSize())),
			Arguments.of(
				points,
				Position.ofPosition(3, points.getSize()),
				Position.ofPosition(4, points.getSize())),
			Arguments.of(
				points,
				Position.ofPosition(5, points.getSize()),
				Position.ofPosition(6, points.getSize()))
		);
	}

	public static Stream<Arguments> 좌표가_유지되는_모음() {
		Points points = Points.ofPoints(Arrays.asList(
			Point.ofPoint(Direction.first(false)),
			Point.ofPoint(Direction.of(false, false)),
			Point.ofPoint(Direction.last(false))
		));
		return Stream.of(
			Arguments.of(points,
				Position.ofPosition(0, points.getSize()),
				Position.ofPosition(0, points.getSize())),
			Arguments.of(
				points,
				Position.ofPosition(1, points.getSize()),
				Position.ofPosition(1, points.getSize())),
			Arguments.of(points,
				Position.ofPosition(2, points.getSize()),
				Position.ofPosition(2, points.getSize()))
		);
	}

	public static Stream<Arguments> 입력된_좌표값이_현재_좌표개수보다_큰_모음() {
		Points points = Points.ofPoints(Arrays.asList(
			Point.ofPoint(Direction.first(false)),
			Point.ofPoint(Direction.last(false))
		));
		return Stream.of(
			Arguments.of(points, 2),
			Arguments.of(points, 10),
			Arguments.of(points, 500)
		);
	}

	@DisplayName("Points가 생성된다.")
	@Test
	void 포인트의_집합이_생성된다() {
		Direction firstDirection = Direction.first(true);
		Direction secondDirection = firstDirection.next(true);
		Direction thirdDirection = secondDirection.next(true);
		Direction lastDirection = Direction.last(true);

		List<Point> points = Arrays.asList(
			Point.ofPoint(firstDirection),
			Point.ofPoint(secondDirection),
			Point.ofPoint(thirdDirection),
			Point.ofPoint(lastDirection)
		);
		assertThat(points.size()).isEqualTo(4);
	}

	@DisplayName("주어진 index 위치 값에서 왼쪽으로 이동이 가능한지 판별한다. 즉, n번째 좌표에서 n-1 좌표로 이동이 가능하다.")
	@MethodSource("왼쪽으로_이동이_가능한_모음")
	@ParameterizedTest
	void 왼쪽으로_이동이_가능하다(Points points, Position givenBeforePosition, Position expectedAfterPosition) {
		Position movedPosition = points.movePosition(givenBeforePosition);
		assertThat(movedPosition.getPosition()).isEqualTo(expectedAfterPosition.getPosition());
	}

	@DisplayName("주어진 index 위치 값에서 오른쪽으로 이동이 가능한지 판별한다. 즉, n번째 좌표에서 n+1 좌표로 이동이 가능하다.")
	@MethodSource("오른쪽으로_이동이_가능한_모음")
	@ParameterizedTest
	void 오른쪽으로_이동이_가능하다(Points points, Position givenBeforePosition, Position expectedAfterPosition) {
		Position movedPosition = points.movePosition(givenBeforePosition);
		assertThat(movedPosition.getPosition()).isEqualTo(expectedAfterPosition.getPosition());
	}

	@DisplayName("연결되지 않은 좌표 값을 지나면 좌표가 변동되지 않는다. 즉, n번쨰 좌표에서 n번쨰 좌표로 위치가 유지된다.")
	@MethodSource("좌표가_유지되는_모음")
	@ParameterizedTest
	void 좌표가_유지된다(Points points, Position givenBeforePosition, Position expectedAfterPosition) {
		Position movedPosition = points.movePosition(givenBeforePosition);
		assertThat(movedPosition.getPosition()).isEqualTo(expectedAfterPosition.getPosition());
	}

	@DisplayName("현재 주어진 좌표의 개수보다 입력된 좌표값이 더 큰 경우 오류를 반환한다.")
	@MethodSource("입력된_좌표값이_현재_좌표개수보다_큰_모음")
	@ParameterizedTest
	void 주어진_좌표값은_좌표개수를_초과_못한다(Points points, int givenBeforePosition) {
		assertThatThrownBy(
			() -> Position.ofPosition(givenBeforePosition, points.getSize())
		).isInstanceOf(IllegalArgumentException.class);
	}
}
