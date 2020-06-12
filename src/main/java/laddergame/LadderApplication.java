package laddergame;

import laddergame.domain.ladder.Ladder;
import laddergame.domain.ladder.RandomBridgeGenerator;
import laddergame.domain.player.Players;
import laddergame.view.InputView;
import laddergame.view.OutputView;

public class LadderApplication {
    public static void main(String[] args) {
        String[] names = InputView.inputPlayerNames();
        Players players = new Players(names);

        int ladderHeight = InputView.inputLadderHeight();

        Ladder ladder = new Ladder(ladderHeight, names.length, new RandomBridgeGenerator());

        OutputView.printLadder(players, ladder);
    }
}
