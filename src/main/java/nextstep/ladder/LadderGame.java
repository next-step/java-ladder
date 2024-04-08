package nextstep.ladder;

import nextstep.ladder.domain.LadderBoard;
import nextstep.ladder.domain.UserNames;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderGame {
	public static void start() {
		UserNames userNames = new UserNames(InputView.InputNames());
		int ladderHeight = InputView.InputLadderHeight();

		LadderBoard ladderBoard = new LadderBoard(ladderHeight, userNames.getUserCount());

		ResultView.printNames(userNames);
		ResultView.printLadderBoard(ladderBoard);
	}

}
