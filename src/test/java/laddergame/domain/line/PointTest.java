package laddergame.domain.line;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class PointTest {

	@Test
	public void 이전_점의_선이_존재하지않을때() {
		Point beforePoint = Point.from(Direction.STRAIGHT);
		Point point = Point.nextOf(beforePoint);

		assertThat(point).as("이전 점에 선이 존재하지 않으면 왼쪽 또는 직선이 생성")
				.extracting("direction")
				.containsAnyOf(Direction.LEFT, Direction.STRAIGHT);
		assertThat(beforePoint).as("새로 생성된 점에 선이 존재하면 이전 점의 방향도 바뀌어야한다.")
				.extracting("direction")
				.containsAnyOf(Direction.RIGHT, Direction.STRAIGHT);
	}

	@Test
	public void 이전_점의_선이_존재할때() {
		Point beforePoint = Point.from(Direction.LEFT);
		Point point = Point.nextOf(beforePoint);

		assertThat(point).as("이전 점에 선이 존재하면 직선만 가능하다.")
				.extracting("direction")
				.containsOnly(Direction.STRAIGHT);
		assertThat(beforePoint).as("이전 점의 방향이 바뀌면 안된다.")
				.extracting("direction")
				.containsOnly(Direction.LEFT);
	}

	@Test
	public void 왼쪽_이동() {
		Point point = Point.from(Direction.LEFT);

		final int index = 3;
		assertThat(point.move(index)).isEqualTo(2);
	}

	@Test
	public void 직진() {
		Point point = Point.from(Direction.STRAIGHT);

		final int index = 3;
		assertThat(point.move(index)).isEqualTo(3);
	}

	@Test
	public void 오른쪽_이동() {
		Point point = Point.from(Direction.RIGHT);

		final int index = 3;
		assertThat(point.move(index)).isEqualTo(4);
	}
}