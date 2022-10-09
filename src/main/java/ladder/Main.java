package ladder;

import ladder.domain.Ladder;
import ladder.domain.RandomLineFactory;
import ladder.view.InputView;
import ladder.view.ResultView;

public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView();

        Ladder ladder = new Ladder(inputView.names().size(), inputView.height(), new RandomLineFactory());

        ResultView.printIntro();
        ResultView.printNames(inputView.names());
        ResultView.printLadder(ladder);
    }
}
