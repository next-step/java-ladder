package step4.controller;

import step4.domain.LadderGame;
import step4.domain.PlayResult;
import step4.domain.Prizes;
import step4.view.InputView;
import step4.view.ResultView;

public class LadderGameController {
    private static final String ALL = "ALL";

    public LadderGameController() {
    }

    public void run() {
        String[] inputNames = InputView.inputPlayerNames();
        String[] inputPrizes = InputView.inputResultPrizes();
        int inputHeight = InputView.inputMaxLadderHeight();

        LadderGame ladderGame = LadderGame.of(inputNames, inputHeight);
        Prizes prizes = Prizes.of(inputPrizes, inputNames.length);

        ResultView.printLadderView(ladderGame.toLaddersDto(), ladderGame.toPlayersDto(), prizes.toPrizeDto());

        PlayResult playResult = ladderGame.play(prizes);
    }
}
