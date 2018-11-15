package laddergame;

import laddergame.domain.Ladder;
import laddergame.domain.LadderGame;
import laddergame.view.InputView;
import laddergame.view.ResultView;

public class LadderGameConsole {

	public static void main(String[] args) {
		String rawPlayers = InputView.inputPlayers();
		int ladderHeight = InputView.inputLadderHeight();

		LadderGame ladderGame = new LadderGame(rawPlayers, ladderHeight);
		Ladder ladder = ladderGame.generateLadder();

		ResultView.printLadder(ladder);
	}
}
