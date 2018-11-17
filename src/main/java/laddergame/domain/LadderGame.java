package laddergame.domain;

import java.util.List;

public class LadderGame {

	private List<Player> players;
	private List<Result> results;

	public LadderGame(String rawPlayers, String rawResults) {
		players = PlayerGenerator.generate(rawPlayers);
		results = ResultGenerator.generate(rawResults);
	}

	public Ladder generateLadder(int ladderHeight) {
		LadderGameInfo ladderGameInfo = new LadderGameInfo(players, results);
		Lines lines = Lines.from(ladderHeight, players.size());
		return new Ladder(ladderGameInfo, lines);
	}
}
