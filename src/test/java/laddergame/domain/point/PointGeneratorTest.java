package laddergame.domain.point;

import org.junit.jupiter.api.Test;
import laddergame.domain.coordinate.Coordinate;
import laddergame.domain.direction.Direction;
import laddergame.domain.direction.strategy.DiceGenerateStrategy;

import static org.assertj.core.api.Assertions.assertThat;

class PointGeneratorTest {

	private final Coordinate zero = new Coordinate(0);
	private final Coordinate one = new Coordinate(1);
	private final Point previous = new Point(zero, Direction.LEFT);
	private final PointGenerator pointGenerator = new PointGenerator(new DiceGenerateStrategy(() -> 1));

	@Test
	void generateNextPoint() {
		assertThat(pointGenerator.generateNextPoint(previous, one)).isEqualTo(new Point(one, Direction.RIGHT));
	}

	@Test
	void generateLineStartPoint() {
		assertThat(pointGenerator.generateLineStartPoint()).isEqualTo(new Point(zero, Direction.RIGHT));
	}

	@Test
	void generateLineEndPoint() {
		Coordinate end = new Coordinate(9);
		assertThat(pointGenerator.generateLineEndPoint(previous, end)).isEqualTo(new Point(end, Direction.DOWN));
	}
}
