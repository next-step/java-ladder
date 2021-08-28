package nextstep.ladder;

import nextstep.ladder.domain.Players;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderGameConsole {

    public static void main(String[] args) {

        InputView inputView = InputView.getInstance();

        final String[] playerNames = inputView.playerNames();
        final int ladderHeight = inputView.askLadderHeight();
        inputView.closeInputScanner();

        final Players players = Players.from(playerNames);

        ResultView resultView = ResultView.getInstance();

    }

}
