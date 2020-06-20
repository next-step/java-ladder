package nextstep.ladder.domain.ladder;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import nextstep.ladder.domain.height.Height;
import nextstep.ladder.domain.line.Lines;
import nextstep.ladder.domain.player.Player;
import nextstep.ladder.domain.player.Players;
import nextstep.ladder.util.painter.RandomPaintingStrategy;

public class LadderTest {

	@DisplayName("입력한 사다리의 높이만큼 사다리 라인이 그려진다.")
	@Test
	void 입력한_사다리_높이만큼_라인이_그려진다() {
		Players players = Players.ofPlayers(
			Arrays.asList(Player.ofNameAndPosition("Jin", 0), Player.ofNameAndPosition("Brian", 1)));
		Height height = Height.ofHeight("5");
		RandomPaintingStrategy randomPaintingStrategy = new RandomPaintingStrategy();
		Ladder ladder = Ladder.ofLadder(players, height, randomPaintingStrategy);
		Lines lines = ladder.getLines();
		int lineSize = lines.size();
		assertThat(height.getHeightValue()).isEqualTo(lineSize);
	}

	@DisplayName("사용자의 인덱스가 게임이 진행되면서 업데이트되고, 이에 대한 최종 결과가 반환된다. 해당 결과는 게임 진행 이전의 결과와 다르게 된다.")
	@Test
	void 사용자의_인덱스가_게임이_진행되며_업데이트된다() {
		//given
		Players players = Players.ofPlayers(
			Arrays.asList(
				Player.ofNameAndPosition("Dan", 0),
				Player.ofNameAndPosition("Dion", 1),
				Player.ofNameAndPosition("Dingo", 2),
				Player.ofNameAndPosition("Solar", 3),
				Player.ofNameAndPosition("David", 4)
			)
		);

		Height height = Height.ofHeight("5");
		RandomPaintingStrategy randomPaintingStrategy = new RandomPaintingStrategy();
		Ladder ladder = Ladder.ofLadder(players, height, randomPaintingStrategy);

		List<Integer> beforeIndexes = ladder.getPlayers().getPlayers().stream()
			.map(Player::getPosition)
			.collect(Collectors.toList());

		//when
		ladder.determinePlayersPositionResult();
		List<Integer> afterIndexes = ladder.getPlayers().getPlayers().stream()
			.map(Player::getPosition)
			.collect(Collectors.toList());

		//then
		assertThat(afterIndexes).isNotEqualTo(beforeIndexes);
	}
}
