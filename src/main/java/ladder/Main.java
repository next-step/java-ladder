package ladder;

import ladder.domain.Ladder;
import ladder.domain.Name;
import ladder.domain.RandomLineFactory;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Name> names = InputView.scanNames();
        Integer height = InputView.scanHeight();

        Ladder ladder = new Ladder(names.size(), height, new RandomLineFactory());

        ResultView.printIntro();
        ResultView.printNames(names);
        ResultView.printLadder(ladder);
    }
}
