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

public class PointsTest {

	@DisplayName("Points가 생성된다.")
	@Test
	void 포인트의_집합이_생성된다() {
		List<Point> points = Arrays.asList(
			Point.ofPoint(true), Point.ofPoint(false), Point.ofPoint(true),
			Point.ofPoint(false)
		);
		assertThat(points.size()).isEqualTo(4);
	}

	@DisplayName("마지막 좌표가 다음 좌표와 연결되어 있으면 오류를 반환한다.")
	@Test
	void 마지막_좌표가_다음_좌표에_연결되지_않는다() {
		List<Point> points = Arrays.asList(
			Point.ofPoint(true),
			Point.ofPoint(true),
			Point.ofPoint(false),
			Point.ofPoint(false),
			Point.ofPoint(true)
		);
		assertThatThrownBy(() -> Points.ofPoints(points))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("last point should not be connected to the next point.");
	}

	public static Stream<Arguments> 연속적으로_연결된_라인들의_모음() {
		return Stream.of(
			Arguments.of(Arrays.asList(
				Point.ofPoint(true),
				Point.ofPoint(true),
				Point.ofPoint(false))),

			Arguments.of(Arrays.asList(
				Point.ofPoint(true),
				Point.ofPoint(true),
				Point.ofPoint(false),
				Point.ofPoint(false),
				Point.ofPoint(false),
				Point.ofPoint(false))));
	}

	@DisplayName("라인끼리는 서로 연속적으로 연결되지 않는다.")
	@MethodSource("연속적으로_연결된_라인들의_모음")
	@ParameterizedTest
	void 라인끼리_연속적으로_연결되지_않는다(List<Point> pointList) {
		assertThatThrownBy(
			() -> Points.ofPoints(pointList))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("illegal input that tries to connect points continuously.");
	}

	public static Stream<Arguments> 왼쪽으로_이동이_가능한_모음() {
		Points points = Points.ofPoints(Arrays.asList(
			Point.ofPoint(false),
			Point.ofPoint(true),
			Point.ofPoint(false),
			Point.ofPoint(true),
			Point.ofPoint(false),
			Point.ofPoint(true),
			Point.ofPoint(false)
		));
		return Stream.of(
			Arguments.of(points, 2, 1),
			Arguments.of(points, 4, 3),
			Arguments.of(points, 6, 5)
		);
	}

	public static Stream<Arguments> 오른쪽으로_이동이_가능한_모음() {
		Points points = Points.ofPoints(Arrays.asList(
			Point.ofPoint(false),
			Point.ofPoint(true),
			Point.ofPoint(false),
			Point.ofPoint(true),
			Point.ofPoint(false),
			Point.ofPoint(true),
			Point.ofPoint(false)
		));
		return Stream.of(
			Arguments.of(points, 1, 2),
			Arguments.of(points, 3, 4),
			Arguments.of(points, 5, 6)
		);
	}

	public static Stream<Arguments> 좌표가_유지되는_모음() {
		Points points = Points.ofPoints(Arrays.asList(
			Point.ofPoint(false),
			Point.ofPoint(false),
			Point.ofPoint(false)
		));
		return Stream.of(
			Arguments.of(points, 0, 0),
			Arguments.of(points, 1, 1),
			Arguments.of(points, 2, 2)
		);
	}

	public static Stream<Arguments> 입력된_좌표값이_현재_좌표개수보다_큰_모음() {
		Points points = Points.ofPoints(Arrays.asList(
			Point.ofPoint(false),
			Point.ofPoint(false)
		));
		return Stream.of(
			Arguments.of(points, 2),
			Arguments.of(points, 10),
			Arguments.of(points, 500)
		);
	}

	@DisplayName("주어진 index 위치 값에서 왼쪽으로 이동이 가능한지 판별한다. 즉, n번째 좌표에서 n-1 좌표로 이동이 가능하다.")
	@MethodSource("왼쪽으로_이동이_가능한_모음")
	@ParameterizedTest
	void 왼쪽으로_이동이_가능하다(Points points, int givenBeforePosition, int expectedAfterPosition) {
		int movedPosition = points.movePosition(givenBeforePosition);
		assertThat(movedPosition).isEqualTo(expectedAfterPosition);
	}

	@DisplayName("주어진 index 위치 값에서 오른쪽으로 이동이 가능한지 판별한다. 즉, n번째 좌표에서 n+1 좌표로 이동이 가능하다.")
	@MethodSource("오른쪽으로_이동이_가능한_모음")
	@ParameterizedTest
	void 오른쪽으로_이동이_가능하다(Points points, int givenBeforePosition, int expectedAfterPosition) {
		int movedPosition = points.movePosition(givenBeforePosition);
		assertThat(movedPosition).isEqualTo(expectedAfterPosition);
	}

	@DisplayName("연결되지 않은 좌표 값을 지나면 좌표가 변동되지 않는다. 즉, n번쨰 좌표에서 n번쨰 좌표로 위치가 유지된다.")
	@MethodSource("좌표가_유지되는_모음")
	@ParameterizedTest
	void 좌표가_유지된다(Points points, int givenBeforePosition, int expectedAfterPosition) {
		int movedPosition = points.movePosition(givenBeforePosition);
		assertThat(movedPosition).isEqualTo(expectedAfterPosition);
	}

	@DisplayName("현재 주어진 좌표의 개수보다 입력된 좌표값이 더 큰 경우 오류를 반환한다.")
	@MethodSource("입력된_좌표값이_현재_좌표개수보다_큰_모음")
	@ParameterizedTest
	void 주어진_좌표값은_좌표개수를_초과_못한다(Points points, int givenBeforePosition) {
		assertThatThrownBy(
			() -> points.movePosition(givenBeforePosition)
		).isInstanceOf(IllegalArgumentException.class);
	}
}
