package step2.domain.line;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step2.domain.Coordinate;
import step2.domain.direction.Direction;
import step2.domain.direction.strategy.DiceGenerateStrategy;
import step2.domain.participant.Participant;
import step2.domain.participant.Participants;
import step2.domain.point.Point;
import step2.domain.point.PointGenerator;
import step2.exception.LadderGameException;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.filter;
import static org.junit.jupiter.api.Assertions.*;

class LineGeneratorTest {

	private final LineGenerator lineGenerator = new LineGenerator(new PointGenerator(new DiceGenerateStrategy(() -> 1)));

	@DisplayName("라인이 겹침없이 생성되는지 테스트")
	@ParameterizedTest
	@MethodSource("provide")
	void generateLine(Participants participants, Line result) {
		assertThat(lineGenerator.generateLine(participants)).isEqualTo(result);
	}

	@Test
	void exceptionTest() {
		Participant solo = new Participant("solo", new Coordinate(0));
		Participants soloParticipants = new Participants(new Participant[]{solo});
		assertThrows(LadderGameException.class, () -> lineGenerator.generateLine(soloParticipants));
	}

	static Stream<Arguments> provide() {
		Coordinate zero = new Coordinate(0);
		Coordinate one = new Coordinate(1);
		Coordinate two = new Coordinate(2);
		Coordinate three = new Coordinate(3);
		Coordinate four = new Coordinate(4);

		Participant participant1 = new Participant("a", zero);
		Participant participant2 = new Participant("b", one);
		Participant participant3 = new Participant("c", two);
		Participant participant4 = new Participant("d", three);
		Participant participant5 = new Participant("e", four);

		Participants participants1 = new Participants(new Participant[]{participant1, participant2, participant3, participant4});
		Participants participants2 = new Participants(new Participant[]{participant1, participant2, participant3, participant4, participant5});

		List<Point> points = List.of(
											new Point(zero, Direction.RIGHT),
											new Point(one, Direction.LEFT),
											new Point(two, Direction.RIGHT),
											new Point(three, Direction.LEFT)

									);
		Line line = new Line(new LinkedList<>(points));
		Line line2 = new Line(new LinkedList<>(points));
		line2.addPoint(new Point(four, Direction.DOWN));
		return Stream.of(
				Arguments.of(participants1, line),
				Arguments.of(participants2, line2)
		);
	}
}
