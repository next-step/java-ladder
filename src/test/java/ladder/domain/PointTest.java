package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by seungwoo.song on 2022-11-01
 */
class PointTest {

	@Test
	void 이동_왼쪽() {
		Point point = new Point(1);
		assertThat(point.move(Direction.LEFT)).isEqualTo(new Point(0));
	}
}