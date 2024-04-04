package nextstep.ladder;

import java.util.List;

public class LadderGame {
	public static void start() {
		List<String> names = InputView.InputNames();
		int ladderHeight = InputView.InputLadderHeight();

		LadderBoard ladderBoard = new LadderBoard(ladderHeight, names.size());

		ResultView.printNames(names);
		ResultView.printLadderBoard(ladderBoard);
	}
}
