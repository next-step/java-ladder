package domain.ladder;

import domain.point.LineVertex;
import domain.point.Point;
import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * Created by hspark on 19/11/2018.
 */
public class LineVertexTest {

	@Test
	public void test_첫번째정점생성() {
		LineVertex vertex = LineVertex.first(() -> true);
		Assertions.assertThat(vertex.getPoint()).isEqualTo(Point.ZERO);
		Assertions.assertThat(vertex.getDirection().isRight()).isTrue();
	}

	@Test
	public void test_첫번째정점생성후_두번째정점() {
		LineVertex vertex = LineVertex.first(() -> true);
		Assertions.assertThat(vertex.getPoint()).isEqualTo(Point.ZERO);
		Assertions.assertThat(vertex.getDirection().isRight()).isTrue();

		LineVertex nextVertex = vertex.next(() -> true);
		Assertions.assertThat(nextVertex.getPoint()).isEqualTo(Point.of(1));
		Assertions.assertThat(nextVertex.getDirection().isLeft()).isTrue();
	}

	@Test
	public void test_두개생성후_마지막정점() {
		LineVertex vertex = LineVertex.first(() -> false);
		Assertions.assertThat(vertex.getPoint()).isEqualTo(Point.ZERO);
		Assertions.assertThat(vertex.getDirection().isRight()).isFalse();

		LineVertex nextVertex = vertex.next(() -> true);
		Assertions.assertThat(nextVertex.getPoint()).isEqualTo(Point.of(1));
		Assertions.assertThat(nextVertex.getDirection().isRight()).isTrue();

		LineVertex lastVertex = nextVertex.last();
		Assertions.assertThat(lastVertex.getPoint()).isEqualTo(Point.of(2));
		Assertions.assertThat(lastVertex.getDirection().isLeft()).isTrue();
	}

	@Test
	public void test_이동() {
		LineVertex vertex = LineVertex.first(() -> true);
		vertex.next(() -> true);
		Point point = vertex.move();
		Assertions.assertThat(point).isEqualTo(Point.of(1));
	}
}