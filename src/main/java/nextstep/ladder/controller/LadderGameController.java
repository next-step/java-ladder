package nextstep.ladder.controller;

import nextstep.ladder.controller.dto.GameInfo;
import nextstep.ladder.domain.Coordinate;
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

        Coordinate.init(new Width(names.length), new Height(height));
        GameInfo gameInfo = new GameInfo(names, height, prizes);
        LadderGame ladderGame = new LadderGame(gameInfo);

        resultView.printLadder(ladderGame);

        ladderGame.play();
        gameResult(ladderGame);
    }

    private void gameResult(LadderGame ladderGame) {
        while (true) {
            System.out.println("");
            String name = inputView.inputName();

            if ("all".equals(name)) {
                resultView.printResultAll(ladderGame);
                break;
            }

            resultView.printResultBy(name, ladderGame);
        }
    }
}
