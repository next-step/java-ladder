package nextstep.ladder.point;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}
