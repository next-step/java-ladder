package laddergame.domain;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class LadderGameInfoTest {

	@Test(expected = IllegalArgumentException.class)
	public void 결과보다_플레이어가_더_많은경우_오류_검증() {
		new LadderGameInfo(
				asList(new Player("pobi"), new Player("crong"), new Player("jk")),
				asList(new Result("꽝"), new Result("5000"))
		);
	}

	@Test(expected = IllegalArgumentException.class)
	public void 플레이어보다_결과가_더_많은경우_오류_검증() {
		new LadderGameInfo(
				asList(new Player("pobi"), new Player("crong")),
				asList(new Result("꽝"), new Result("5000"), new Result("꽝"))
		);
	}

	@Test
	public void 플레이어명으로_위치_찾기() {
		LadderGameInfo ladderGameInfo = new LadderGameInfo(
				asList(new Player("pobi"), new Player("crong")),
				asList(new Result("꽝"), new Result("5000"))
		);

		final String playerName = "crong";
		assertThat(ladderGameInfo.findPlayerIndex2(playerName)).isEqualTo(1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void 플레이어명으로_위치_찾기_실패() {
		LadderGameInfo ladderGameInfo = new LadderGameInfo(
				asList(new Player("pobi"), new Player("crong")),
				asList(new Result("꽝"), new Result("5000"))
		);

		final String playerName = "cro";
		ladderGameInfo.findPlayerIndex2(playerName);
	}

	@Test
	public void 좌표에_해당하는_결과_조회() {
		LadderGameInfo ladderGameInfo = new LadderGameInfo(
				asList(new Player("pobi"), new Player("crong")),
				asList(new Result("꽝"), new Result("5000"))
		);

		final int resultIndex = 1;
		assertThat(ladderGameInfo.findResult(resultIndex)).isEqualTo("5000");
	}
}