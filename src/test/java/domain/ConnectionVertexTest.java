package domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by hspark on 18/11/2018.
 */
public class ConnectionVertexTest {
	@Test(expected = IllegalArgumentException.class)
	public void test_생성시_인접해야함() {
		new ConnectionPoint(new Point(1), new Point(3));
	}

	@Test
	public void test_연결점이있는지_확인() {
		ConnectionPoint connectionPoint = new ConnectionPoint(new Point(0), new Point(1));
		boolean isConnection = connectionPoint.isConnection(new Point(1));
		Point point = connectionPoint.getConnectionPoint(new Point(1));
		assertThat(isConnection).isTrue();
		assertThat(point).isEqualTo(new Point(0));
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_연결점이없음() {
		ConnectionPoint connectionPoint = new ConnectionPoint(new Point(0), new Point(1));
		boolean isConnection = connectionPoint.isConnection(new Point(2));
		assertThat(isConnection).isFalse();
		connectionPoint.getConnectionPoint(new Point(2));
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_좌우가_바뀜() {
		new ConnectionPoint(new Point(1), new Point(0));
	}
}