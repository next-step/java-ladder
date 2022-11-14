package ladder;

import ladder.domain.Ladder;
import ladder.domain.Name;
import ladder.domain.RandomLadderConnectDecider;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.List;

public class App {
    private static final String ALL = "all";

    public static void main(String[] args) {
        List<Name> names = InputView.inputPeople();
        List<String> results = InputView.inputResults();
        int height = InputView.inputHeight();

        Ladder ladder = new Ladder(height, names.size(), new RandomLadderConnectDecider());

        ResultView.PrintResult(names, ladder, height, results);

        boolean end = false;
        while (!end) {
            end = showResult(ladder);
        }
    }

    private static boolean showResult(Ladder ladder) {
        Name name = InputView.inputShowResult();
        if (name.equals(ALL)) {
            ResultView.printAllResult();
            return true;
        }
        ResultView.printPersonResult("");
        return false;
    }
}
