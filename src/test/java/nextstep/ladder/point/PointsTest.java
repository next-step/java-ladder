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
}
