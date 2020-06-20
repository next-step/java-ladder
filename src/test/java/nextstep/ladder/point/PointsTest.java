package nextstep.ladder.point;

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
}
