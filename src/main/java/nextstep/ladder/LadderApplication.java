package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Players;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderApplication {
    public static void main(String[] args) {
        String inputPlayers = InputView.inputPlayers();
        Players player = new Players(inputPlayers);
        int ladderHeight = InputView.inputLadderCount();
        Ladder ladder = new Ladder(player.size(), ladderHeight);
        ResultView.printLadderGame(player, ladder);

    }
}
