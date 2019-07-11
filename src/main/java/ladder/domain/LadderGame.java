package ladder.domain;

import java.util.HashMap;
import java.util.Map;

public class LadderGame {
	private final Players players;
	private final Ladder ladder;
	private final Ladder2 ladder2;

	public LadderGame(Players players, int heightOfLadder) {
		this.players = players;
		this.ladder = LadderGenerator.generateLadder(heightOfLadder, this.players);
		this.ladder2 = LadderGenerator.generateLadder2(heightOfLadder, this.players);
	}

	public LadderResult play(Rewards rewards) {
		if (!(players.size() == rewards.size())) {
			throw new IllegalArgumentException();
		}

		Map<Player, Reward> ladderResult = new HashMap<>();
		for (Player player : players.getPlayers()) {
			Point_old result = ladder.resultByPlayer(players.pointOfPlayer(player));
			ladderResult.put(player, rewards.rewardByResult(result));
		}
		return new LadderResult(ladderResult);
	}
	
	public LadderResult play2(Rewards rewards) {
		if (!(players.size() == rewards.size())) {
			throw new IllegalArgumentException();
		}

		Map<Player, Reward> ladderResult = new HashMap<>();
		for (Player player : players.getPlayers()) {
			Position resultPosition = ladder2.resultByPlayer(players.getPosition(player));
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
	
	public Ladder2 getLadder2() {
		return ladder2;
	}

}
