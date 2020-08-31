package laddergame.domain.ladder;

import org.junit.jupiter.api.Test;
import laddergame.domain.Coordinate;
import laddergame.domain.direction.strategy.DiceGenerateStrategy;
import laddergame.domain.line.LineGenerator;
import laddergame.domain.participant.Participant;
import laddergame.domain.participant.Participants;
import laddergame.domain.point.PointGenerator;
import laddergame.dto.GameConstructData;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGeneratorTest {

	private final LineGenerator lineGenerator = new LineGenerator(new PointGenerator(new DiceGenerateStrategy(() -> 1)));
	private final LadderGenerator ladderGenerator = new LadderGenerator(lineGenerator);

	@Test
	void generateLadder() {
		Participant participant1 = new Participant("a", new Coordinate(0));
		Participant participant2 = new Participant("b", new Coordinate(1));
		Participants participants = new Participants(List.of(participant1, participant2));
		LadderHeight ladderHeight = new LadderHeight(1);
		GameConstructData constructData = new GameConstructData(participants, ladderHeight);

		assertThat(ladderGenerator.generateLadder(constructData)).isEqualTo(new Ladder(List.of(lineGenerator.generateLine(participants))));
	}
}
