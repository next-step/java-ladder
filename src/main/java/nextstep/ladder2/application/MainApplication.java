package nextstep.ladder2.application;

import nextstep.ladder.util.StringUtil;
import nextstep.ladder.view.InputView;
import nextstep.ladder2.domain.Ladder;
import nextstep.ladder2.view.ResultView;

import java.util.List;

public class MainApplication {
    public static void main(String[] args) {
        String nameString = InputView.inputNameString();
        String resultString = InputView.inputResultString();

        int height = InputView.inputLadderHeight();
        List<String> names = StringUtil.separator(nameString);
        List<String> results = StringUtil.separator(resultString);
        Ladder ladder = Ladder.of(height, names.size());
        ResultView.printNames(names);
        ResultView.printLadder(ladder);
        ResultView.printResults(results);

        String findResultName = null;
        InputView.emptyLine();
        while (!"all".equals(findResultName)) {
            findResultName = InputView.inputFindResultString();
            if (names.contains(findResultName)) {
                ResultView.printResult(results.get(ladder.move(names.indexOf(findResultName))));
            }
            if ("all".equals(findResultName)) {
                ResultView.printAllResult(results, names, ladder);
            }
        }
        InputView.closeScanner();
    }
}
