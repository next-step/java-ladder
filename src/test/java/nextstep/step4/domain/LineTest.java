package nextstep.step4.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineTest {

	@DisplayName("라인을 생성한다.")
	@Test
	void create() {
		List<Point> points = Arrays.asList(Point.first(false), Point.first(false).next(true));
		Line line = new Line(points);
		assertThat(line).isEqualTo(new Line(points));
	}

	@DisplayName("라인의 각 지점에서 이동한 후 최종 위치를 얻는다.")
	@Test
	void move() {
		Point first = Point.first(true);
		Line line = new Line(Arrays.asList(first, first.next(false), first.next(false).next(true), first.next(false).next(true).last()));
		assertThat(line.move(0)).isEqualTo(1);
		assertThat(line.move(1)).isEqualTo(0);
		assertThat(line.move(2)).isEqualTo(3);
		assertThat(line.move(3)).isEqualTo(2);
	}

}
