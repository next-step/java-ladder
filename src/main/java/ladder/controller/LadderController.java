package ladder.controller;

import ladder.domain.ladder.Height;
import ladder.domain.ladder.Ladder;
import ladder.domain.user.Players;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderController {

    public static void main(String[] args) {
        Players players = new Players(InputView.printInputNames());
        Height height = new Height(InputView.printInputLadderHeight());

        Ladder ladder = Ladder.createLadder(players, height);

        ResultView.printResult(players.getPlayers(), ladder.getLines());
        ResultView.printLadder(ladder.getLines());
    }

}
