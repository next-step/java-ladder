package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineTest {

	@DisplayName("좌표목록으로 라인을 생성한다.")
	@Test
	void test1() {
		Points points = new Points(true, false, true, false);
		Line line = new Line(points);
		assertThat(line).isEqualTo(new Line(new Points(true, false, true, false)));
	}
}
