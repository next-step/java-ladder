package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import nextstep.ladder.domain.strategy.LineRandomStrategy;

public class LineTest {
	private Line line;

	@BeforeEach
	void init() {
		line = new Line(10, new LineRandomStrategy());
	}

	@DisplayName(value = "한 라인의 길이는 참가자 수보다 1 작다.")
	@Test
	void lineLength() {
		int expect = 9;
		int lineLength = line.getPoints().size();

		assertThat(lineLength).isEqualTo(expect);
	}

	@DisplayName(value = "한 포인트가 존재하면 양쪽 포인트는 존재하지 않는다.")
	@Test
	void isFalseBothSideOfTruePoint() {
		List<Boolean> points = line.getPoints();
		for (int i = 0; i < points.size(); i++) {
			boolean point = points.get(i);
			if (point) {
				boolean prePoint = getPoint(points, i - 1);
				boolean nextPoint = getPoint(points, i + 1);

				assertThat(prePoint).isFalse();
				assertThat(nextPoint).isFalse();
			}
		}
	}

	boolean getPoint(List<Boolean> points, int index) {
		boolean result;
		try {
			result = points.get(index);
		} catch (IndexOutOfBoundsException e) {
			result = false;
		}
		return result;
	}
}
