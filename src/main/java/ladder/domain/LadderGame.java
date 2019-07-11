package ladder.domain;

import java.util.HashMap;
import java.util.Map;

public class LadderGame {
	private final Players players;
	private final Ladder ladder;

	public LadderGame(Players players, int heightOfLadder) {
		this.players = players;
		this.ladder = LadderGenerator.generateLadder(heightOfLadder, this.players);
	}

	
	public LadderResult play(Rewards rewards) {
		if (!(players.size() == rewards.size())) {
			throw new IllegalArgumentException();
		}

		Map<Player, Reward> ladderResult = new HashMap<>();
		for (Player player : players.getPlayers()) {
			Position resultPosition = ladder.resultByPlayer(players.getPosition(player));
			ladderResult.put(player, rewards.rewardByResult(resultPosition));
		}
		return new LadderResult(ladderResult);
	}

	public Players getPlayers() {
		return players;
	}

	public Ladder getLadder() {
		return ladder;
	}

}
