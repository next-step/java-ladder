package ladder;

import ladder.domain.Players;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderGameApplication {
    public static void main(String[] args) {
        String[] playerNames = InputView.players();
        Players players = Players.create(playerNames);
        ResultView.players(players.getNames());

    }
}
