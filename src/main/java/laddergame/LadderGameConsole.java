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

	private static final String INITIAL_CHARACTER = "";
	private static final String GAME_OVER = "all";

	public static void main(String[] args) {
		Players players = Players.fromComma(InputView.inputPlayers());
		Results results = Results.fromComma(InputView.inputResults());
		LadderGame ladderGame = new LadderGame(players, results);

		int ladderHeight = InputView.inputLadderHeight();
		Ladder ladder = ladderGame.generateLadder(ladderHeight);
		ResultView.printLadder(ladder.display());

		String playerName = INITIAL_CHARACTER;
		while(!GAME_OVER.equals(playerName)) {
			playerName = play(ladder);
		}
	}

	private static String play(Ladder ladder) {
		String playerName = InputView.inputPlayerName();
		if(GAME_OVER.equals(playerName)) {
			finalResult(ladder);
			return GAME_OVER;
		}
		run(ladder, playerName);
		return playerName;
	}

	private static void run(Ladder ladder, String playerName) {
		try {
			LadderResult result = ladder.start(playerName);
			ResultView.printResult(result);
		} catch (IllegalArgumentException e) {
			ResultView.printFailMessage(e.getMessage());
		}
	}

	private static void finalResult(Ladder ladder) {
		LadderFinalResult ladderFinalResult = ladder.end();
		ResultView.printFinalResult(ladderFinalResult);
	}
}
