package laddergame.domain.ladder;

import laddergame.domain.coordinate.Coordinate;
import laddergame.domain.direction.Direction;
import laddergame.domain.direction.strategy.DiceGenerateStrategy;
import laddergame.domain.line.Line;
import laddergame.domain.line.LineGenerator;
import laddergame.domain.participant.Participant;
import laddergame.domain.participant.Participants;
import laddergame.domain.point.Point;
import laddergame.domain.point.PointGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.LinkedList;
import java.util.List;

import static laddergame.domain.line.TestFixture.fromPoints;
import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

	private static final Ladder ladder;
	private static final Coordinate ZERO = new Coordinate(0);
	private static final Coordinate ONE = new Coordinate(1);
	private static final Coordinate TWO = new Coordinate(2);
	private static final Coordinate THREE = new Coordinate(3);

	static {
		Line firstLine = fromPoints(new LinkedList<>(List.of(new Point(ZERO, Direction.RIGHT), new Point(ONE, Direction.LEFT), new Point(TWO, Direction.RIGHT), new Point(THREE, Direction.LEFT))));
		Line secondLine = fromPoints(new LinkedList<>(List.of(new Point(ZERO, Direction.DOWN), new Point(ONE, Direction.RIGHT), new Point(TWO, Direction.LEFT), new Point(THREE, Direction.DOWN))));
		Line thirdLine = fromPoints(new LinkedList<>(List.of(new Point(ZERO, Direction.RIGHT), new Point(ONE, Direction.LEFT), new Point(TWO, Direction.DOWN), new Point(THREE, Direction.DOWN))));
		Line fourthLine = fromPoints(new LinkedList<>(List.of(new Point(ZERO, Direction.DOWN), new Point(ONE, Direction.RIGHT), new Point(TWO, Direction.LEFT), new Point(THREE, Direction.DOWN))));
		Line fifthLine = fromPoints(new LinkedList<>(List.of(new Point(ZERO, Direction.RIGHT), new Point(ONE, Direction.LEFT), new Point(TWO, Direction.RIGHT), new Point(THREE, Direction.LEFT))));
		ladder = new Ladder(List.of(firstLine, secondLine, thirdLine, fourthLine, fifthLine));
	}

	@DisplayName("객체 생성 테스트")
	@Test
	void constructionTest() {
		LineGenerator lineGenerator = new LineGenerator(new PointGenerator(new DiceGenerateStrategy(() -> 1)));
		Participant participant = new Participant("a", new Coordinate(0));
		Participant participant2 = new Participant("b", new Coordinate(1));
		Participants participants = new Participants(List.of(participant, participant2));
		assertThat(new Ladder(List.of(lineGenerator.generateLine(participants)))).isEqualTo(new Ladder(List.of(lineGenerator.generateLine(participants))));
	}

	@DisplayName("게임 플레이 테스트")
	@ParameterizedTest
	@CsvSource(value = {"0,0", "1,3", "2,2", "3,1"})
	void playGame(int startIndex, int resultIndex) {
		Participant participant = new Participant(String.valueOf(startIndex), new Coordinate(startIndex));
		assertThat(ladder.getParticipantFinalCoordinate(participant)).isEqualTo(new Coordinate(resultIndex));
	}

}
