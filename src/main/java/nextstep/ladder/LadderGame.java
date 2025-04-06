package nextstep.ladder;

import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Players;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderGame {

    public static void main(String[] args) {
        String playerNames = InputView.getInputPlayerNames();
        Height laddersHeight = InputView.getLaddersHeight();

        Players players = Players.of(playerNames);
        Ladder ladder = new Ladder(players.size(), laddersHeight);

        ResultView.printPlayers(players);
        ResultView.printLadder(ladder);

    }

}
