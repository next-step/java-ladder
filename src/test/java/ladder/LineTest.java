package ladder;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ladder.domain.Line;

public class LineTest {

	@Test
	@DisplayName("라인 생성 테스트")
	void lineMakeTest() {
		Line line = new Line(countOfPerson -> {
			List<Boolean> points = new ArrayList<>();
			points.add(false);
			points.add(true);
			points.add(false);
			points.add(false);
			return points;
		}, 4);
		assertThat(line.getPoints().size()).isEqualTo(4);
		assertThat(line.getPoints()).containsExactly(false, true, false, false);
	}

	@Test
	@DisplayName("라인 생성 랜덤 테스트")
	void lineMakeRandomTest() {
		Line line = new Line(5);
		assertThat(line.getPoints().size()).isEqualTo(5);
	}
}
