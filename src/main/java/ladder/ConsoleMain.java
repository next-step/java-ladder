package ladder;

import ladder.domain.Ladder;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.List;

public class ConsoleMain {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        List<String> names = inputView.printInputUserNames();

        int height = inputView.printInputLadderHeight();
        int countOfPerson = names.size();

        Ladder ladder = new Ladder(countOfPerson, height);

        ResultView resultView = new ResultView();
        resultView.printNames(names);
        resultView.printLadder(ladder);
    }
}
