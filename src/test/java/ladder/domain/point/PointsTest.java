package ladder.domain.point;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PointsTest {

	@DisplayName("객체 생성 테스트")
	@Test
	void of() {
		List<Point> pointList = Arrays.asList(
				Point.of(true),
				Point.of(false),
				Point.of(true),
				Point.of(false));

		Points points = Points.of(pointList);

		assertThat(points.size()).isEqualTo(4);
	}

	@DisplayName("마지막 좌표가 다음 좌표와 연결되어 있으면 IllegalArgumentException")
	@Test
	void lastPointIsConnectedToNext() {
		List<Point> points = Arrays.asList(
				Point.of(true),
				Point.of(false),
				Point.of(true),
				Point.of(false),
				Point.of(true));

		assertThatThrownBy(() -> Points.of(points))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("마지막 좌표");
	}

	@DisplayName("좌표가 연속으로 연결되어 있으면 IllegalArgumentException")
	@ParameterizedTest
	@MethodSource("continuouslyConnectedPointsArguments")
	void continuouslyConnectedPoints(List<Point> points) {
		assertThatThrownBy(() -> Points.of(points))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("연속으로 연결");
	}

	public static Stream<Arguments> continuouslyConnectedPointsArguments() {
		return Stream.of(
				Arguments.of(Arrays.asList(
						Point.of(true),
						Point.of(true),
						Point.of(false))),

				Arguments.of(Arrays.asList(
						Point.of(true),
						Point.of(true),
						Point.of(false),
						Point.of(false),
						Point.of(false),
						Point.of(false))));
	}

	@DisplayName("오른쪽으로 연결된 n번째 좌표를 지나면 n+1번째 위치로 이동한다")
	@ParameterizedTest
	@MethodSource("moveToRightArguments")
	void moveToRight(Points points, int position, int expected) {
		int movedPointIndex = points.moveSideFrom(position);
		assertThat(movedPointIndex).isEqualTo(expected);
	}

	public static Stream<Arguments> moveToRightArguments() {
		Points points = Points.of(Arrays.asList(
				Point.of(false),
				Point.of(true),
				Point.of(false),
				Point.of(true),
				Point.of(false),
				Point.of(true),
				Point.of(false)));

		return Stream.of(
				Arguments.of(points, 1, 2),
				Arguments.of(points, 3, 4),
				Arguments.of(points, 5, 6));
	}

	@DisplayName("왼쪽으로 연결된 n번째 좌표를 지나면 n-1번째 위치로 이동한다")
	@ParameterizedTest
	@MethodSource("moveToLeftArguments")
	void moveToLeft(Points points, int position, int expected) {
		int movedPointIndex = points.moveSideFrom(position);
		assertThat(movedPointIndex).isEqualTo(expected);
	}

	public static Stream<Arguments> moveToLeftArguments() {
		Points points = Points.of(Arrays.asList(
				Point.of(false),
				Point.of(true),
				Point.of(false),
				Point.of(true),
				Point.of(false),
				Point.of(true),
				Point.of(false)));

		return Stream.of(
				Arguments.of(points, 2, 1),
				Arguments.of(points, 4, 3),
				Arguments.of(points, 6, 5));
	}

	@DisplayName("연결되지 않은 n번째 좌표를 지나면 n번째 위치로 이동한다")
	@ParameterizedTest
	@MethodSource("stayArguments")
	void stay(Points points, int position, int expected) {
		int movedPointIndex = points.moveSideFrom(position);
		assertThat(movedPointIndex).isEqualTo(expected);
	}

	public static Stream<Arguments> stayArguments() {
		Points points = Points.of(Arrays.asList(
				Point.of(false),
				Point.of(false),
				Point.of(false)));

		return Stream.of(
				Arguments.of(points, 0, 0),
				Arguments.of(points, 1, 1),
				Arguments.of(points, 2, 2));
	}

	@DisplayName("좌표 수보다 큰 위치에서 이동하려고 하면 IllegalArgumentException")
	@Test
	void moveSideFrom_greaterThanPointCount() {
		Points points = Points.of(Arrays.asList(
				Point.of(false),
				Point.of(false)));

		assertThatThrownBy(() -> points.moveSideFrom(2))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("좌표 수보다 큰 위치");
	}
}
