package laddergame.domain.ladder;

import org.junit.jupiter.api.Test;
import laddergame.domain.Coordinate;
import laddergame.domain.direction.strategy.DiceGenerateStrategy;
import laddergame.domain.line.LineGenerator;
import laddergame.domain.participant.Participant;
import laddergame.domain.participant.Participants;
import laddergame.domain.point.PointGenerator;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

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
