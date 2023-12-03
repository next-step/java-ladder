package nextstep.ladder.controller;

import nextstep.ladder.model.*;
import nextstep.ladder.util.InputConverter;
import nextstep.ladder.view.LadderInputView;
import nextstep.ladder.view.LadderOutputView;

import static nextstep.ladder.model.Result.BANNED;

public class LadderApplication {
    private final LadderInputView ladderInputView;
    private final LadderOutputView ladderOutputView;

    public LadderApplication(LadderInputView ladderInputView, LadderOutputView ladderOutputView) {
        this.ladderInputView = ladderInputView;
        this.ladderOutputView = ladderOutputView;
    }

    public void run() {
        String[] names = InputConverter.splitWithComma(ladderInputView.getPeople());
        People people = new People(names);

        String[] resultsInput = InputConverter.splitWithComma(ladderInputView.getResultInput());
        Results results = new Results(resultsInput);

        Height height = new Height(ladderInputView.getHeight());

        LineGenerator lineGenerator = new LineGenerator(people, height);
        Lines lines = new Lines(lineGenerator.generateLines(), height);
        Ladder ladder = new Ladder(people, lines);

        Game game = new Game(ladder, results);
        GameResult gameResult = game.playGame();

        ladderOutputView.getLadderResult(ladder, results);
        showResult(gameResult);
    }

    private void showResult(GameResult gameResult) {
        boolean endFlag = true;
        while (endFlag) {
            String resultName = ladderInputView.getResultName();
            viewTotalOrOne(gameResult, resultName);
            endFlag = isEndAddition(resultName);
        }
    }

    private void viewTotalOrOne(GameResult gameResult, String resultName) {
        if (BANNED.contains(resultName)) {
            ladderOutputView.viewTotalGameResult(gameResult);
            return;
        }
        ladderOutputView.viewGameResult(gameResult, resultName);
    }

    private boolean isEndAddition(String resultName) {
        if (BANNED.contains(resultName)) {
            return false;
        }
        return true;
    }
}
