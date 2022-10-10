package ladder;

import ladder.domain.Ladder;
import ladder.domain.RandomLineFactory;
import ladder.external.RandomFactory;
import ladder.view.InputView;
import ladder.view.ResultView;

public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView();

        Ladder ladder = new Ladder(inputView.names().size(), inputView.height(), new RandomLineFactory(new RandomFactory()));

        ResultView.printIntro();
        ResultView.printNames(inputView.names());
        ResultView.printLadder(ladder);
    }
}
