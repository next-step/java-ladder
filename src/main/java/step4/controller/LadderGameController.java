package step4.controller;

import step4.domain.LadderGame;
import step4.domain.PlayResult;
import step4.domain.Prizes;
import step4.view.InputView;
import step4.view.ResultView;

public class LadderGameController {
    private static final String ALL = "ALL";

    private final LadderGame ladderGame;
    private final Prizes prizes;

    public LadderGameController(String[] inputNames, String[] inputPrizes, int inputHeight) {
        ladderGame = LadderGame.of(inputNames, inputHeight);
        prizes = Prizes.of(inputPrizes, inputNames.length);
    }

    public void play() {
        ResultView.printLadderView(ladderGame.toLaddersDto(), ladderGame.toPlayersDto(), prizes.toPrizeDto());
        PlayResult playResult = ladderGame.play(prizes);
        result(playResult);
    }

    public void result(PlayResult playResult) {
        String prizeOfPlayer = InputView.inputPrizeOfPlayer();
        while (!ALL.equals(prizeOfPlayer)) {
            ResultView.printMatchOfPrize(playResult.getMatchPlayer(ladderGame.findPlayer(prizeOfPlayer)));
            prizeOfPlayer = InputView.inputPrizeOfPlayer();
        }
        ResultView.printAllMatchOfPrize(playResult.getAllMatchPlayer());
    }
}
