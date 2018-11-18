package laddergame.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class LadderGameInfoTest {

	@Test
	public void 플레이어명으로_위치_찾기() {
		LadderGameInfo ladderGameInfo = new LadderGameInfo(
				Players.fromComma("pobi,honux,crong,jk"),
				Results.fromComma("꽝,5000,꽝,3000")
		);

		assertThat(ladderGameInfo.getPlayerIndex("honux")).isEqualTo(1);
	}
}