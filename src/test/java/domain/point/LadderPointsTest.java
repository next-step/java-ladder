package domain.point;

import domain.ladder.LadderLine;
import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * Created by hspark on 18/11/2018.
 */
public class LadderPointsTest {

	@Test
	public void test_생성() {
		LadderPoints ladderPoints = new LadderPoints(1);
		Point point = ladderPoints.findCurrentPointByStartPoint(Point.of(0));
		Assertions.assertThat(point).isEqualTo(Point.of(0));
	}

	@Test
	public void test_이동() {
		LadderPoints ladderPoints = new LadderPoints(2);
		LadderLine ladderLine = new LadderLine(2, () -> true);
		ladderPoints.move(Point.of(0), ladderLine);
		Point currentPoint = ladderPoints.findCurrentPointByStartPoint(Point.of(0));
		Assertions.assertThat(currentPoint).isEqualTo(Point.of(1));
	}
}