package step2.domain.ladder;

import org.junit.jupiter.api.Test;
import step2.domain.Coordinate;
import step2.domain.direction.strategy.DiceGenerateStrategy;
import step2.domain.line.LineGenerator;
import step2.domain.participant.Participant;
import step2.domain.participant.Participants;
import step2.domain.point.PointGenerator;
import step2.dto.GameConstructData;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

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
