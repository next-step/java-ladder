package step3;

import step3.domain.Game;
import step3.domain.Ladder;
import step3.view.InputView;
import step3.view.ResultView;

public class LadderApplication {
	public static void main(String[] args) {
		String[] usersName = InputView.inputUsersName();
		Game game = new Game(usersName);

		String[] gameResults = InputView.inputGameResult();
		game.setGameResult(gameResults);

		int ladderHeight = InputView.inputLadderHeight();

		Ladder ladder = game.start(ladderHeight);
		ResultView.printCreatedLadderInfo(ladder);
	}
}
