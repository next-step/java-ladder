package ladder;

import ladder.domain.user.Users;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderMain {
	public static void main(String[] args) {
		Users users = InputView.getPlayerNames();
		int ladderHeight = InputView.getLadderHeight();
		OutputView.printResult(users, ladderHeight);
	}
}
