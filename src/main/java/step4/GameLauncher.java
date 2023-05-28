package step4;

import step3.view.InputView;
import step4.domain.Ladder;
import step4.view.LadderGameResultMap;
import step4.view.Names;
import step4.view.ResultView;
import step4.view.Results;

import java.util.List;

public class GameLauncher {
    public static void main(String[] args) {
        List<String> stringNames = InputView.inputNames();
        List<String> stringResults = InputView.inputResults();
        int height = InputView.inputLadderHeight();

        Names names = new Names(stringNames);
        Results results = new Results(stringResults, names.size());
        Ladder ladder = new Ladder(names.size(), height);

        LadderGameResultMap resultMap = new LadderGameResultMap(names, ladder, results);
        ResultView.printLadderGame(names, ladder, results);
        ResultView.printResult(resultMap);
    }
}
