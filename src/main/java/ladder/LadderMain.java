package ladder;

import ladder.domain.Ladder;
import ladder.domain.Name;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.List;
import java.util.Random;

public class LadderMain {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        List<Name> names = inputView.requestName();

        int height = inputView.requestHeight();
        Ladder ladder = new Ladder(height, names.size(), () -> new Random().nextBoolean());

        ResultView resultView = new ResultView();
        resultView.printLadder(names, ladder);
    }
}
