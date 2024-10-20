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
        Height height = inputView.getHeightFromUser();

        Lines lines = new Lines(names.size(), height);

        resultView.showNames(names);
        resultView.showLines(lines);
    }
}
