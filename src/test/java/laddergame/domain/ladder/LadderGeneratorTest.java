package laddergame.domain.ladder;

import laddergame.domain.prize.Prizes;
import org.junit.jupiter.api.Test;
import laddergame.domain.coordinate.Coordinate;
import laddergame.domain.direction.strategy.DiceGenerateStrategy;
import laddergame.domain.line.LineGenerator;
import laddergame.domain.participant.Participant;
import laddergame.domain.participant.Participants;
import laddergame.domain.point.PointGenerator;
import laddergame.dto.GameCriteria;

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
		Prizes prizes = new Prizes(new String[]{"꽝", "우승"}, participants.getCount());
		LadderHeight ladderHeight = new LadderHeight(1);
		GameCriteria constructData = new GameCriteria(participants, prizes, ladderHeight);

		assertThat(ladderGenerator.generateLadder(constructData)).isEqualTo(new Ladder(List.of(lineGenerator.generateLine(participants))));
	}
}
