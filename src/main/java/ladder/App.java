package ladder;

import ladder.domain.Ladder;
import ladder.domain.LadderRunner;
import ladder.domain.Name;
import ladder.domain.RandomLadderConnectDecider;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.List;
import java.util.Map;

public class App {
    private static final String ALL = "all";

    public static void main(String[] args) {
        List<Name> names = InputView.inputPeople();
        List<String> results = InputView.inputResults();
        int height = InputView.inputHeight();

        Ladder ladder = new Ladder(height, names.size(), new RandomLadderConnectDecider());

        ResultView.PrintResult(names, ladder, height, results);

        Map<Name, String> ladderResult = new LadderRunner(names, ladder).run(height, results);

        boolean end = false;
        while (!end) {
            end = showResult(ladderResult);
        }
    }

    private static boolean showResult(Map<Name, String> ladderResult) {
        Name name = InputView.inputShowResult();
        if (name.equals(ALL)) {
            ResultView.printAllResult(ladderResult);
            return true;
        }
        ResultView.printPersonResult(ladderResult.get(name));
        return false;
    }
}
