package ladder;

import ladder.domain.ladder.Ladder;
import ladder.domain.result.Results;
import ladder.domain.user.Users;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderMain {
	public static void main(String[] args) {
		Users users = InputView.getPlayerNames();
		Results results = InputView.getResults(users);
		int ladderHeight = InputView.getLadderHeight();
		Ladder ladder = OutputView.printLadderResult(users, ladderHeight, results);
		String matchUser = InputView.getMatchUser();
		OutputView.printResult(ladder, matchUser);

	}
}
