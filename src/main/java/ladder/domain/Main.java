package ladder.domain;

import ladder.view.InputView;
import ladder.view.ResultView;

public class Main {

    public static void main(String[] args) {

        String playersName = InputView.inputPlayers();
        int ladderHeight = InputView.inputLadderHeight();

        LadderPlayers ladderPlayers = LadderPlayers.ofComma(playersName);

        Ladder ladder = new Ladder();
        ladder.generateLadder(ladderHeight, ladderPlayers.totalPlayerCount());

        ResultView.drawLadderPlayers(ladderPlayers);
        ResultView.drawLadder(ladder);
    }
}
