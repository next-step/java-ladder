package ladder.domain;

import ladder.model.LadderNode;
import ladder.model.PlayerGoalPair;
import ladder.model.PlayerRailPair;

import java.util.List;
import java.util.stream.Collectors;

class LadderHeader {

	private PlayerEntry playerEntry;

	private LadderBody ladderBody;

	public LadderHeader(List<String> playerNames, LadderBody ladderBody) {
		this.ladderBody = ladderBody;
		this.playerEntry = new PlayerEntry();
		playerNames.forEach(playerEntry::append);
	}

	public PlayerGoalPair getReachedGoal(String playerName) {
		return this.getReachedGoal(playerEntry.getEntry(playerName));
	}

	private PlayerGoalPair getReachedGoal(PlayerRailPair player) {
		return new PlayerGoalPair(player.getPlayerName(), ladderBody.getResult(player.getRailNumber()));
	}

	public List<PlayerGoalPair> getResult() {
		return this.playerEntry.entries()
				.stream()
				.map(entry -> this.getReachedGoal(entry))
				.collect(Collectors.toList());
	}

	public List<LadderNode> getNodes() {
		return this.ladderBody.getNodes();
	}
}
