package laddergame.domain;

import laddergame.domain.coordinate.Coordinate;
import laddergame.domain.direction.strategy.DiceGenerateStrategy;
import laddergame.domain.ladder.LadderGenerator;
import laddergame.domain.ladder.LadderHeight;
import laddergame.domain.line.LineGenerator;
import laddergame.domain.participant.Participant;
import laddergame.domain.participant.Participants;
import laddergame.domain.point.PointGenerator;
import laddergame.domain.prize.Prizes;
import laddergame.dto.GameCriteria;
import laddergame.dto.GameResult;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGameTest {

	@ParameterizedTest
	@MethodSource("provide")
	void runGame(LadderGame ladderGame, GameResult gameResult) {
		GameResult givenResult = ladderGame.rumGame();
		assertThat(givenResult).isEqualTo(gameResult);
	}

	static Stream<Arguments> provide() {
		LineGenerator lineGenerator = new LineGenerator(new PointGenerator(new DiceGenerateStrategy(() -> 1)));
		LadderGenerator ladderGenerator = new LadderGenerator(lineGenerator);
		Participant participant1 = new Participant("a", new Coordinate(0));
		Participant participant2 = new Participant("b", new Coordinate(1));
		Participants participants = new Participants(List.of(participant1, participant2));
		Prizes prizes = new Prizes(new String[]{"꽝", "우승"}, participants.getCount());
		LadderHeight ladderHeight = new LadderHeight(1);
		GameCriteria gameCriteria = new GameCriteria(participants, prizes, ladderHeight);

		GameResult gameResult = new GameResult(Map.of("a", "우승", "b", "꽝"));

		return Stream.of(
				Arguments.of(LadderGame.of(gameCriteria, ladderGenerator.generateLadder(gameCriteria)), gameResult)
		);
	}
}
