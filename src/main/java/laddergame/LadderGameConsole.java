package laddergame;

import laddergame.domain.Ladder;
import laddergame.domain.LadderGame;
import laddergame.view.InputView;
import laddergame.view.ResultView;

public class LadderGameConsole {

	public static void main(String[] args) {
		String rawPlayers = InputView.inputPlayers();
		String rawResults = InputView.inputResults();
		int ladderHeight = InputView.inputLadderHeight();

		LadderGame ladderGame = new LadderGame(rawPlayers, rawResults);
		Ladder ladder = ladderGame.generateLadder(ladderHeight);
		ResultView.printLadder(ladder);

		String playerName = InputView.inputPlayerName();
		while(!"all".equals(playerName)) {
			try {
				String result = ladder.start(playerName);
				ResultView.printResult(result);
			} catch (Exception e) {
				System.out.println("\n" + e.getMessage());
			}

			playerName = InputView.inputPlayerName();
		}
		ResultView.printResult(ladder.end());
	}
}
