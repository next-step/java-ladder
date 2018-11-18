package laddergame.domain;

public class LadderGame {

	private Players players;
	private Results results;

	public LadderGame(Players players, Results results) {
		if(players.getPlayerCount() != results.getResultCount()) {
			throw new IllegalArgumentException("플레이어와 결과의 수가 다릅니다.");
		}
		this.players = players;
		this.results = results;
	}

	public Ladder generateLadder(int ladderHeight) {
		LadderGameInfo ladderGameInfo = new LadderGameInfo(players, results);
		Lines lines = Lines.from(ladderHeight, players.getPlayerCount());
		return new Ladder(ladderGameInfo, lines);
	}
}
