package nextstep.ladder.controller;

import nextstep.ladder.controller.dto.GameInfo;
import nextstep.ladder.controller.dto.GameResult;
import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.domain.wrapper.Height;
import nextstep.ladder.domain.wrapper.Width;
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
        gameResult(result, ladderGame);
    }

    private void gameResult(GameResult gameResult, LadderGame ladderGame) {
        while (true) {
            String name = inputView.inputName();

            if ("all".equals(name)) {
                resultView.printResultAll(gameResult, ladderGame);
                break;
            }

            resultView.printResultBy(name, gameResult);
        }
    }
}
