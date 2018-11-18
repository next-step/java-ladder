package laddergame.domain;

import org.junit.Test;

public class LadderGameTest {

	@Test(expected = IllegalArgumentException.class)
	public void 결과보다_플레이어가_더_많은경우_오류_검증() {
		new LadderGame(
				Players.fromComma("pobi,crong,jk"),
				Results.fromComma("꽝,5000")
		);
	}

	@Test(expected = IllegalArgumentException.class)
	public void 플레이어보다_결과가_더_많은경우_오류_검증() {
		new LadderGame(
				Players.fromComma("pobi,crong"),
				Results.fromComma("꽝,5000,꽝")
		);
	}
}