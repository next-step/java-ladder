package laddergame;

import laddergame.domain.Ladder;
import laddergame.domain.LadderFinalResult;
import laddergame.domain.LadderGame;
import laddergame.domain.LadderResult;
import laddergame.domain.Players;
import laddergame.domain.Results;
import laddergame.view.InputView;
import laddergame.view.ResultView;

public class LadderGameConsole {

	public static void main(String[] args) {
		Players players = Players.fromComma(InputView.inputPlayers());
		Results results = Results.fromComma(InputView.inputResults());
		LadderGame ladderGame = new LadderGame(players, results);

		int ladderHeight = InputView.inputLadderHeight();
		Ladder ladder = ladderGame.generateLadder(ladderHeight);
		ResultView.printLadder(ladder);


		String playerName = InputView.inputPlayerName();
		while(!"all".equals(playerName)) {
			try {
				LadderResult result = ladder.start(playerName);
				ResultView.printResult(result);
			} catch (Exception e) {
				System.out.println("\n" + e.getMessage());
			}
			playerName = InputView.inputPlayerName();
		}

		LadderFinalResult ladderFinalResult = ladder.end();
		ResultView.printFinalResult(ladderFinalResult);
	}
}
