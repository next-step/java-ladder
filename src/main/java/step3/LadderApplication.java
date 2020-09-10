package step3;

import step3.domain.Game;
import step3.domain.Ladder;
import step3.view.InputView;
import step3.view.ResultView;

public class LadderApplication {
	private static final String GAMEOVER_USERNAME = "all";

	public static void main(String[] args) {
		String[] usersName = InputView.inputUsersName();
		Game game = new Game(usersName);

		String[] gameResults = InputView.inputGameResult();
		game.setGameResult(gameResults);

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
			ResultView.printGameResult(name, game.getUserResult(name));
		}
	}
}
