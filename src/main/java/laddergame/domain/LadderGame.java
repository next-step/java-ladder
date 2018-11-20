package laddergame.domain;

import laddergame.domain.player.Players;
import laddergame.domain.result.Results;
import laddergame2.domain.LadderLines;
import laddergame2.domain.generator.PointGenerationStrategy;
import laddergame2.domain.generator.PointGenerator;

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

	public Ladder generateLadder(int ladderHeight, PointGenerationStrategy pointGenerationStrategy) {
		LadderGameInfo ladderGameInfo = new LadderGameInfo(players, results);
		PointGenerator pointGenerator = new PointGenerator(players.getPlayerCount(), pointGenerationStrategy);
		LadderLines ladderLines = LadderLines.init(ladderHeight, pointGenerator);
		return new Ladder(ladderGameInfo, ladderLines);
	}
}
