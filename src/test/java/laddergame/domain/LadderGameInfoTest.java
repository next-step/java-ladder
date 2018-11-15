package laddergame.domain;

import static java.util.Arrays.asList;

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
}