package laddergame;

import laddergame.domain.Ladder;
import laddergame.domain.result.Printable;

public class LadderGameRunner {

	private static final String GAME_OVER_CONDITION = "all";

	private Ladder ladder;

	public LadderGameRunner(Ladder ladder) {
		this.ladder = ladder;
	}

	public Printable run(String playerName) {
		if(isOver(playerName)) {
			return ladder.end();
		}
		return ladder.start(playerName);
	}

	public boolean isOver(String playerName) {
		return GAME_OVER_CONDITION.equals(playerName);
	}
}
