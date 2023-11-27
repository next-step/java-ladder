package nextstep.ladder.controller;

import nextstep.ladder.controller.dto.GameInfo;
import nextstep.ladder.controller.dto.GameResult;
import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderGameController {

    private final InputView inputView;
    private final ResultView resultView;

    public LadderGameController(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void start() {
        String[] names = inputView.inputPlayerName();
        String[] prizes = inputView.inputPrize(names.length);
        int height = inputView.inputHeight();

        GameInfo gameInfo = new GameInfo(names, height, prizes);
        LadderGame ladderGame = new LadderGame(gameInfo);

        resultView.printLadder(ladderGame);

        GameResult result = ladderGame.play();
        showResult(result);
    }

    private void showResult(GameResult gameResult) {
        String name = inputView.inputName();
        boolean isAll = resultView.printResultBy(name, gameResult);

        if (isAll) {
            return;
        }

        showResult(gameResult);
    }
}
