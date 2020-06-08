package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderLineTest {

	@DisplayName("사람 수만큼의 좌표를 갖는다")
	@Test
	void test() {
		LadderLine ladderLine = new LadderLine(5);
		List<Point> points = ladderLine.getPoints();

		assertThat(points.size()).isEqualTo(5);
	}
}