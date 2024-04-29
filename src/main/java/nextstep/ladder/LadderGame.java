package nextstep.ladder;


import nextstep.ladder.domain.GameUsers;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderGameResult;
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

		Ladder ladder = new Ladder(ladderHeight, userNames.size());
		ladder.play(gameUsers);

		LadderGameResult result = gameUsers.makeResult(executionResult);

		ResultView.printNames(userNames);
		ResultView.printLadderBoard(ladder);
		ResultView.printLadderGameResult(executionResult);
		ResultView.printLadderGameResultPerson(result);
	}

}
