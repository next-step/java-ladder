package nextstep.ladder;

import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.player.Players;
import nextstep.ladder.ui.InputView;
import nextstep.ladder.ui.ResultView;

public class LadderController {

    public static void main(String[] args) {
        Players players = new Players(InputView.getPlayersName());
        int ladderHeight = InputView.getLadderHeight();

        Ladder ladder = new Ladder(players, ladderHeight);

        ResultView.printLadder(ladder);
    }
}
