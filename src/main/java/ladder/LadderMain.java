package ladder;

import ladder.domain.Height;
import ladder.domain.Ladder;
import ladder.domain.LadderGame;
import ladder.domain.Lines;
import ladder.domain.Names;
import ladder.domain.ResultName;
import ladder.domain.Results;
import ladder.domain.ResultsBoard;
import ladder.ui.InputView;
import ladder.ui.ResultView;

public class LadderMain {

	private static final int RESULT_CHECK_TRY_COUNT = 5;

	public static void main(String[] args) {
		Names names = new Names(InputView.inputNames());
		Results results = new Results(InputView.inputResults(), names);
		Height height = new Height(InputView.inputHeight());

		Ladder ladder = new Ladder(Lines.of(height, names));
		ResultView.printNames(names);
		ResultView.printLadder(ladder);
		ResultView.printResults(results);

		LadderGame ladderGame = new LadderGame(ladder, names);
		ResultsBoard resultsBoard = ladderGame.makeResultsBoard(names, results);
		for (int i = 0; i < LadderMain.RESULT_CHECK_TRY_COUNT; i++) {
			ResultName resultName = new ResultName(names, InputView.inputResultName());
			ResultView.printGameResult(resultsBoard, resultName);
		}
	}
}
