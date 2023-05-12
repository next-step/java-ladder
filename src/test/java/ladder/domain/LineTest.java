package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineTest {

	@DisplayName("유효한 좌표 목록으로 가로 라인 생성 시, 객체를 반환한다.")
	@Test
	void test1() {
		Points points = Points.of(true, false, true, false);
		Line line = new Line(points);
		assertThat(line).isEqualTo(new Line(Points.of(true, false, true, false)));
	}
}
