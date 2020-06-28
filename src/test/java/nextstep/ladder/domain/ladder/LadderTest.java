package nextstep.ladder.domain.ladder;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import nextstep.ladder.domain.height.Height;
import nextstep.ladder.domain.line.Lines;
import nextstep.ladder.domain.player.Player;
import nextstep.ladder.domain.player.Players;
import nextstep.ladder.util.painter.RandomPaintingStrategy;

public class LadderTest {

	@DisplayName("입력한 사다리의 높이만큼 사다리 라인이 그려진다.")
	@Test
	@Order(1)
	void 입력한_사다리_높이만큼_라인이_그려진다() {
		int playerSize = 2;
		Players players = Players.ofPlayers(
			Arrays.asList(
				Player.ofNameAndPositionAndSize("Jin", 0, playerSize),
				Player.ofNameAndPositionAndSize("Brian", 1, playerSize))
		);
		Height height = Height.ofHeight("5");
		RandomPaintingStrategy randomPaintingStrategy = new RandomPaintingStrategy();
		Ladder ladder = Ladder.ofLadder(players, height, randomPaintingStrategy);
		Lines lines = ladder.getLines();
		int lineSize = lines.size();
		assertThat(height.getHeightValue()).isEqualTo(lineSize);
	}

	@DisplayName("사용자의 인덱스가 게임이 진행되면서 업데이트되고, 이에 대한 최종 결과가 반환된다. 해당 결과는 게임 진행 이전의 결과와 다르게 된다.")
	@Order(2)
	@Test
	void 사용자의_인덱스가_게임이_진행되며_업데이트된다() {
		//given
		int playerSize = 5;
		Players players = Players.ofPlayers(
			Arrays.asList(
				Player.ofNameAndPositionAndSize("Dan", 0, playerSize),
				Player.ofNameAndPositionAndSize("Dion", 1, playerSize),
				Player.ofNameAndPositionAndSize("Dingo", 2, playerSize),
				Player.ofNameAndPositionAndSize("Solar", 3, playerSize),
				Player.ofNameAndPositionAndSize("David", 4, playerSize)
			)
		);

		Height height = Height.ofHeight("5");
		RandomPaintingStrategy randomPaintingStrategy = new RandomPaintingStrategy();
		Ladder ladder = Ladder.ofLadder(players, height, randomPaintingStrategy);

		List<Integer> beforeIndexes = ladder.getPlayers().getPlayers().stream()
			.map(player -> player.getCurrentPosition().getPosition())
			.collect(Collectors.toList());

		//when
		ladder.determinePlayersCurrentPositionResult();
		List<Integer> afterIndexes = ladder.getPlayers().getPlayers().stream()
			.map(player -> player.getCurrentPosition().getPosition())
			.collect(Collectors.toList());

		//then
		assertThat(afterIndexes).isNotEqualTo(beforeIndexes);
	}
}
