package step4;

import step4.domain.Game;
import step4.domain.Ladder;
import step4.view.InputView;
import step4.view.ResultView;

public class LadderApplication {
	private static final String GAMEOVER_USERNAME = "all";

	public static void main(String[] args) {
		String[] usersName = InputView.inputUsersName();
		String[] gameResults = InputView.inputGameResult();

		Game game = new Game(usersName, gameResults);

		int ladderHeight = InputView.inputLadderHeight();

		Ladder ladder = game.start(ladderHeight);
		ResultView.printCreatedLadderInfo(usersName, ladder, gameResults);

		String name;
		while(true) {
			name = InputView.inputResultUser();
			if(GAMEOVER_USERNAME.equals(name)) {
				ResultView.printGameResult(game.getAllUserResult());
				break;
			}
			ResultView.printGameResult(game.getUserResult(name));
		}
	}
}
