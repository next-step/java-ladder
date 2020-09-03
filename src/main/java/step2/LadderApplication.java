package step2;

import step2.domain.Game;
import step2.view.InputView;

public class LadderApplication {
	public static void main(String[] args) {
		String[] usersName = InputView.inputUsersName();
		int ladderHeight = InputView.inputLadderHeight();

		Game.start(usersName, ladderHeight);


	}
}
