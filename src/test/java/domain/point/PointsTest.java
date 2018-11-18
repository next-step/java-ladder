package domain.point;

import domain.ladder.LadderLayer;
import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * Created by hspark on 18/11/2018.
 */
public class PointsTest {

	@Test
	public void test_생성() {
		Points points = new Points(1);
		Point point = points.findCurrentPointByStartPoint(Point.of(0));
		Assertions.assertThat(point).isEqualTo(Point.of(0));
	}

	@Test
	public void test_이동() {
		Points points = new Points(2);

		LadderLayer ladderLayer = new LadderLayer(2);
		ladderLayer.drawLines(() -> true);

		points.move(Point.of(0), ladderLayer);
		Point currentPoint = points.findCurrentPointByStartPoint(Point.of(0));
		Assertions.assertThat(currentPoint).isEqualTo(Point.of(1));
	}
}