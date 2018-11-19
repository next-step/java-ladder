package domain.ladder;

import domain.point.Point;
import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * Created by hspark on 20/11/2018.
 */
public class LadderLineTest {
	@Test
	public void test_이동() {
		LadderLine ladderLine = new LadderLine(3, () -> true);
		Point point = Point.ZERO;
		Point movePoint = ladderLine.move(point);
		Assertions.assertThat(movePoint).isEqualTo(Point.of(1));
	}
}