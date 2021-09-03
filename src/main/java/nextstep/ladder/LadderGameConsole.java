package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.domain.LadderGameSettings;
import nextstep.ladder.domain.LadderSize;
import nextstep.ladder.domain.Players;
import nextstep.ladder.strategy.RandomDrawLineStrategy;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderGameConsole {

    public static void main(String[] args) {

        InputView inputView = InputView.getInstance();

        final Players players = Players.from(inputView.playerNames());
        final LadderSize ladderSize = LadderSize.of(players.count(), inputView.askLadderHeight());
        inputView.closeInputScanner();

        final LadderGameSettings settings = LadderGameSettings.of(ladderSize, new RandomDrawLineStrategy());

        Ladder ladder = LadderGame.createLadder(settings);

        ResultView resultView = ResultView.getInstance();
        resultView.showLadderGame(players,ladder);

    }

}
