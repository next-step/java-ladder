package ladder.domain;

import org.junit.jupiter.api.BeforeEach;

public class LadderResultTest {
	LadderGame ladderGame; // players, ladder
	Rewards rewards;

	@BeforeEach
	void setup() {
		Players players = Players.register("moon, jae, heon, keep, going");
		int heightOfLadder = 5;

		this.ladderGame = new LadderGame(players, heightOfLadder);
		this.rewards = Rewards.of("꽝은, 없다, 전진만, 있을, 뿐");
	}
	
}
