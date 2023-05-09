package ladder;

import java.util.ArrayList;
import java.util.List;

import ladder.domain.Height;
import ladder.domain.Ladder;
import ladder.domain.LadderGame;
import ladder.domain.Names;
import ladder.domain.Points;
import ladder.domain.ResultName;
import ladder.domain.Results;
import ladder.domain.ResultsBoard;
import ladder.ui.InputView;
import ladder.ui.ResultView;

public class LadderMain {

	public static void main(String[] args) {
		Names names = new Names(InputView.inputNames());
		Results results = new Results(InputView.inputResults(), names);
		Height height = new Height(InputView.inputHeight());
		List<Points> pointsList = new ArrayList<>();
		for (int i = 0; i < height.getHeight(); i++) {
			pointsList.add(new Points(Points.generate(names)));
		}
		Ladder ladder = new Ladder(pointsList);
		ResultView.printNames(names);
		ResultView.printLadder(ladder);
		ResultView.printResults(results);

		LadderGame ladderGame = new LadderGame(ladder, names);
		ResultsBoard resultsBoard = ladderGame.makeResultsBoard(names, results);
		for (int i = 0; i < 5; i++) {
			ResultName resultName = new ResultName(names, InputView.inputResultName());
			ResultView.printGameResult(resultsBoard, resultName);
		}
	}
}
