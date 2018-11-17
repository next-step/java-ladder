package laddergame.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.Test;

public class DirectionTest {

	@Test
	public void 오른쪽_모서리_방향_생성() {
		List<Direction> straights = IntStream.rangeClosed(1, 100)
				.mapToObj(i -> Direction.from(RightEdgeDirectionStrategy.getInstance()))
				.collect(Collectors.toList());
		assertThat(straights).containsOnly(Direction.LEFT, Direction.STRAIGHT);
	}

	@Test
	public void 왼쪽_반대방향() {
		assertThat(Direction.LEFT.getOppositeDirection()).isEqualTo(Direction.RIGHT);
	}

	@Test
	public void 오른쪽_반대방향() {
		assertThat(Direction.RIGHT.getOppositeDirection()).isEqualTo(Direction.LEFT);
	}

	@Test
	public void 직선_반대방향() {
		assertThat(Direction.STRAIGHT.getOppositeDirection()).isEqualTo(Direction.STRAIGHT);
	}
}