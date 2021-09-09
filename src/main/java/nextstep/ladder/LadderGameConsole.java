package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderDrawingSettings;
import nextstep.ladder.domain.LadderGameMain;
import nextstep.ladder.domain.LadderGamePrizes;
import nextstep.ladder.domain.LadderGameResult;
import nextstep.ladder.domain.LadderGameSettings;
import nextstep.ladder.domain.LadderLabels;
import nextstep.ladder.domain.LadderSize;
import nextstep.ladder.domain.Players;
import nextstep.ladder.strategy.RandomDrawLineStrategy;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderGameConsole {

    public static void main(String[] args) {

        InputView inputView = InputView.getInstance();

        final Players players = Players.from(inputView.askplayerNames());
        final LadderSize ladderSize = LadderSize.of(players.count(), inputView.askLadderHeight());
        final LadderGamePrizes ladderGamePrizes = LadderGamePrizes
            .from(inputView.askLadderGamePrizes());
        final LadderLabels ladderLabels = LadderLabels.from(players, ladderGamePrizes);

        final LadderDrawingSettings drawingSettings = LadderDrawingSettings.of(ladderSize, ladderLabels, new RandomDrawLineStrategy());
        final LadderGameSettings gameSettings = LadderGameSettings.of(players, ladderGamePrizes, drawingSettings);

        LadderGameMain gameMain = new LadderGameMain(gameSettings);
        final LadderGameResult ladderGameResult = gameMain.playGame();
        final Ladder ladder = gameMain.getLadder();

        ResultView resultView = ResultView.getInstance();
        resultView.showLadderGame(ladder);

        String playerName = inputView.askPlayerNameForResult();
        ResultView.showGameResult(playerName, ladderGameResult);

        inputView.closeInputScanner();


    }

}
