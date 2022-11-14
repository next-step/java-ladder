package ladder;

import ladder.domain.Ladder;
import ladder.domain.Name;
import ladder.domain.RandomLadderConnectDecider;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Name> names = InputView.inputPeople();
        int height = InputView.inputHeight();

        Ladder ladder = new Ladder(height, names.size(), new RandomLadderConnectDecider());

        ResultView.PrintResult(names, ladder, height);
    }
}
