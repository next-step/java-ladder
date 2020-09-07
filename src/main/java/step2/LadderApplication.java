package step2;

import step2.domain.Game;
import step2.domain.Ladder;
import step2.view.InputView;
import step2.view.ResultView;

public class LadderApplication {
	public static void main(String[] args) {
		String[] usersName = InputView.inputUsersName();
		Game game = new Game(usersName);

		int ladderHeight = InputView.inputLadderHeight();

		Ladder ladder = game.start(ladderHeight);
		ResultView.printCreatedLadderInfo(ladder);

	}
}
