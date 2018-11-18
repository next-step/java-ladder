package domain.ladder;

/**
 * Created by hspark on 17/11/2018.
 */

import domain.point.Point;
import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * 1. 이동 좌표를 받고 이동 가능하면 변경된 위치를 반환한다.
 */
public class LadderLineTest {

	@Test
	public void test_이동한_위치_반환() {
		LadderLine ladderLine = new LadderLine(Point.of(0), Point.of(1));
		ladderLine.draw();
		Point movePosition = ladderLine.getMovePosition(Point.of(0));
		Assertions.assertThat(movePosition).isEqualTo(Point.of(1));
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_이동불가능한_사다리() {
		LadderLine ladderLine = new LadderLine(Point.of(0), Point.of(1));
		ladderLine.getMovePosition(Point.of(2));
	}
}