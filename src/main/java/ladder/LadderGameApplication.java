package ladder;

import ladder.domain.Ladder;
import ladder.domain.Players;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.List;

public class LadderGameApplication {
    public static void main(String[] args) {
        List<String> playerNames = InputView.players();
        Players players = Players.create(playerNames);
        ResultView.players(players.getNames());

        Integer ladderHeight = InputView.ladderHeight();
        Ladder ladder = new Ladder(players, ladderHeight);
        ladder.operate();

        ResultView.result(ladder);
    }
}
