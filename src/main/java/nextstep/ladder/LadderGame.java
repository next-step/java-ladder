package nextstep.ladder;

import nextstep.ladder.domain.GameUsers;
import nextstep.ladder.domain.LadderBoard;
import nextstep.ladder.domain.UserNames;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.util.List;

public class LadderGame {
	public static void start() {
		UserNames userNames = new UserNames(InputView.InputNames());
		List<String> executionResult = InputView.InputExecutionResult();
		int ladderHeight = InputView.InputLadderHeight();

		GameUsers gameUsers = new GameUsers(userNames);

		LadderBoard ladderBoard = new LadderBoard(ladderHeight, userNames.size());
		gameUsers.moveAllUsersOnLadderBoard(ladderBoard);
		List<Integer> resultPosition = gameUsers.getResultPosition();

		ResultView.printNames(userNames);
		ResultView.printLadderBoard(ladderBoard);
	}

}
