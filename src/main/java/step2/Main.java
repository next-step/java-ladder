package step2;

import step2.UI.InputView;
import step2.UI.OutputView;

public class Main {

    public static void main(String[] args) {
        String playersNames = InputView.inputPlayerName();
        Players players = Players.newPlayers(playersNames);

        int ladderHeight = InputView.inputLadderHeight();
        Ladder ladder = Ladder.newLadder(ladderHeight, players.size());

        OutputView.outputView(ladder, players.getPlayers());
    }
}
