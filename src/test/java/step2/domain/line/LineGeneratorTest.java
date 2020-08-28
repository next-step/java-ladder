package step2.domain.line;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step2.domain.Coordinate;
import step2.domain.direction.Direction;
import step2.domain.direction.strategy.DiceGenerateStrategy;
import step2.domain.point.Point;
import step2.domain.point.PointGenerator;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LineGeneratorTest {

	private final LineGenerator lineGenerator = new LineGenerator(new PointGenerator(new DiceGenerateStrategy(() -> 1)));

	@DisplayName("라인이 겹침없이 생성되는지 테스트")
	@ParameterizedTest
	@MethodSource("provide")
	void generateLine(int participantCount, Line result) {
		assertThat(lineGenerator.generateLine(participantCount)).isEqualTo(result);
	}

	static Stream<Arguments> provide() {
		List<Point> points = List.of(
											new Point(new Coordinate(0), Direction.RIGHT),
											new Point(new Coordinate(1), Direction.LEFT),
											new Point(new Coordinate(2), Direction.RIGHT),
											new Point(new Coordinate(3), Direction.LEFT)

									);
		Line line = new Line(new LinkedList<>(points));
		Line line2 = new Line(new LinkedList<>(points));
		line2.addPoint(new Point(new Coordinate(4), Direction.DOWN));
		return Stream.of(
				Arguments.of(4, line),
				Arguments.of(5, line2)
		);
	}
}
