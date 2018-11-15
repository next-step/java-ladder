package laddergame.domain;

import java.util.List;

public class LadderGame {

	private String rawPlayers;
	private int ladderHeight;

	public LadderGame(String rawPlayers, int ladderHeight) {
		this.rawPlayers = rawPlayers;
		this.ladderHeight = ladderHeight;
	}

	public Ladder generateLadder() {
		List<Player> players = PlayerGenerator.generate(rawPlayers);
		List<Line> lines = LadderGenerator.generate(ladderHeight, players.size());
		return new Ladder(players, lines);
	}
}
