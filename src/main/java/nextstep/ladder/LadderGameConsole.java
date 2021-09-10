package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderGameMain;
import nextstep.ladder.domain.LadderGamePrizes;
import nextstep.ladder.domain.LadderGameResult;
import nextstep.ladder.domain.LadderGameSettings;
import nextstep.ladder.domain.LadderHeight;
import nextstep.ladder.domain.Players;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderGameConsole {

    public static void main(String[] args) {

        final Players players = Players.from(InputView.askPlayerNames());
        final LadderHeight ladderHeight = LadderHeight.of(InputView.askLadderHeight());
        final LadderGamePrizes ladderGamePrizes = LadderGamePrizes.from(InputView.askLadderGamePrizes());
        final LadderGameSettings gameSettings = LadderGameSettings.of(players, ladderHeight, ladderGamePrizes);

        final LadderGameMain gameMain = LadderGameMain.initialize(gameSettings);
        final Ladder ladder = gameMain.getLadder();
        final LadderGameResult ladderGameResult = gameMain.getGameResult();

        ResultView resultView = ResultView.getInstance();
        resultView.showLadderGame(ladder);

        String playerName = InputView.askPlayerNameForResult();
        ResultView.showGameResult(playerName, ladderGameResult);

    }

}
