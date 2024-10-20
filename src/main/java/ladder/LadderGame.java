package ladder;

import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.List;

public class LadderGame {
    private final InputView inputView;
    private final ResultView resultView;

    public LadderGame(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void run() {
        List<Name> names = inputView.getNamesFromUser();
        System.out.println("names = " + names);
    }
}
