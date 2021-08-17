package ladder.controller;

import ladder.model.GameResults;
import ladder.model.Height;
import ladder.model.Lines;
import ladder.model.Name;
import ladder.model.Player;
import ladder.model.Players;
import ladder.model.Results;
import ladder.service.LadderCreate;
import ladder.service.LadderGame;
import ladder.view.LadderInputView;
import ladder.view.LadderOutputView;

public class LadderController {

	public static void main(String[] args) {
		Players players = new Players(LadderInputView.inputParticipationPlayer());
		Results results = new Results(LadderInputView.inputGameResult(), players.findPlayerCount());
		Height height = new Height(LadderInputView.inputLadderHeight());

		Lines ladderLines = LadderCreate.createLadder(players, height);
		GameResults gameResults = LadderGame.startLadderGame(ladderLines, players);

		LadderOutputView.printLadderGameResultStart();
		LadderOutputView.printPlayersName(players);
		LadderOutputView.printResultCreateLadder(ladderLines);
		LadderOutputView.printResultsName(results);

		Player player = new Player(new Name(LadderInputView.inputResultPlayer()));

		LadderOutputView.printResultLadderGame(gameResults.findResultOfPerson(player), results);
	}
}
