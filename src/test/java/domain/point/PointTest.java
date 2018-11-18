package domain.point;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by hspark on 18/11/2018.
 */
public class PointTest {

	@Test
	public void test_인접() {
		Point point = Point.of(1);
		Point otherPoint = Point.of(2);

		assertThat(point.isAdjacent(otherPoint)).isTrue();
		assertThat(point.getDiff(otherPoint)).isEqualTo(-1);
	}

	@Test
	public void test_인접하지_않음() {
		Point point = Point.of(1);
		Point otherPoint = Point.of(3);

		assertThat(point.isAdjacent(otherPoint)).isFalse();
		assertThat(point.getDiff(otherPoint)).isEqualTo(-2);
	}
}