package nextstep.ladder.entity;

import org.junit.jupiter.api.Test;

public class LadderTest {

	@Test
	void Ladder_Test() {
		// given
		Users users = new Users("pobi,honux,crong,jk");

		// when
		Ladder ladder = new Ladder(users, 5);

		// then
		System.out.println(ladder.toString());
	}
}
