package ladder;

import ladder.view.InputView;
import ladder.view.Names;
import ladder.view.ResultView;

import java.util.List;

public class LadderGame {
    private final InputView inputView;
    private final ResultView resultView;
    private final LineGenerateStrategy lineGenerateStrategy;

    public LadderGame(InputView inputView, ResultView resultView, LineGenerateStrategy lineGenerateStrategy) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.lineGenerateStrategy = lineGenerateStrategy;
    }

    public void run() {
        List<String> namesFromUser = inputView.getNamesFromUser();
        Names names = new Names(namesFromUser);

        int heightFromUser = inputView.getHeightFromUser();
        Height height = new Height(heightFromUser);

        Lines lines = new Lines(names, height, lineGenerateStrategy);

        resultView.showNames(names);
        resultView.showLines(lines);
    }
}
