package nextstep.ladder.step2;

import nextstep.ladder.step2.domain.Ladder;
import nextstep.ladder.step2.domain.Players;
import nextstep.ladder.step2.view.InputView;
import nextstep.ladder.step2.view.ResultView;

public class LadderApplication {
    public static void main(String[] args) {
        String inputPlayers = InputView.inputPlayers();
        Players player = new Players(inputPlayers);
        int ladderHeight = InputView.inputLadderCount();
        Ladder ladder = new Ladder();
        ladder.createLadder(player.getPlayerCount(), ladderHeight);
        ResultView.printLadderGame(player, ladder);

    }
}
