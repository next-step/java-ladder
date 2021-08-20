package ladder.service;

import java.util.stream.Collectors;

import ladder.model.GameResult;
import ladder.model.GameResults;
import ladder.model.Lines;
import ladder.model.Players;

public class LadderGame {

	public static GameResults startLadderGame(Lines lines, Players players) {
		return new GameResults(players.getPlayers()
			.stream()
			.map(player -> new GameResult(player,
				lines.findResultPosition(players.findPlayerPosition(player))))
			.collect(Collectors.toList()));
	}

}
