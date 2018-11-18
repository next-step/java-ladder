package domain.point;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by hspark on 18/11/2018.
 */
public class ConnectionPointTest {
	@Test(expected = IllegalArgumentException.class)
	public void test_생성시_인접해야함() {
		new ConnectionPoint(Point.of(1), Point.of(3));
	}

	@Test
	public void test_연결점이있는지_확인() {
		ConnectionPoint connectionPoint = new ConnectionPoint(Point.of(0), Point.of(1));
		boolean isConnection = connectionPoint.isConnection(Point.of(1));
		Point point = connectionPoint.getConnectionPoint(Point.of(1));
		assertThat(isConnection).isTrue();
		assertThat(point).isEqualTo(Point.of(0));
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_연결점이없음() {
		ConnectionPoint connectionPoint = new ConnectionPoint(Point.of(0), Point.of(1));
		boolean isConnection = connectionPoint.isConnection(Point.of(2));
		assertThat(isConnection).isFalse();
		connectionPoint.getConnectionPoint(Point.of(2));
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_좌우가_바뀜() {
		new ConnectionPoint(Point.of(1), Point.of(0));
	}
}