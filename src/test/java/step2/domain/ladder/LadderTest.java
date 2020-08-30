package step2.domain.ladder;

import org.junit.jupiter.api.Test;
import step2.domain.Coordinate;
import step2.domain.direction.Direction;
import step2.domain.direction.strategy.DiceGenerateStrategy;
import step2.domain.line.Line;
import step2.domain.line.LineGenerator;
import step2.domain.participant.Participant;
import step2.domain.participant.Participants;
import step2.domain.point.Point;
import step2.domain.point.PointGenerator;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

	@Test
	void constructionTest() {
		LineGenerator lineGenerator = new LineGenerator(new PointGenerator(new DiceGenerateStrategy(() -> 1)));
		Participant participant = new Participant("a", new Coordinate(0));
		Participant participant2 = new Participant("b", new Coordinate(1));
		Participants participants = new Participants(List.of(participant, participant2));
		assertThat(new Ladder(List.of(lineGenerator.generateLine(participants)))).isEqualTo(new Ladder(List.of(lineGenerator.generateLine(participants))));
	}

}
