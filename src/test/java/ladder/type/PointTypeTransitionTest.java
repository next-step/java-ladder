package ladder.type;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ladder.domain.Point;

public class PointTypeTransitionTest {

	@DisplayName("좌표타입을 좌표객체로 전환한다.")
	@Test
	void test1() {
		assertThat(PointTypeTransition.toPoint(PointType.FALSE_FALSE)).isEqualTo(new Point(false, false));
		assertThat(PointTypeTransition.toPoint(PointType.FALSE_TRUE)).isEqualTo(new Point(false, true));
		assertThat(PointTypeTransition.toPoint(PointType.TRUE_FALSE)).isEqualTo(new Point(true, false));
	}
}
