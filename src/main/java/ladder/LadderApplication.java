package ladder;

import ladder.game.LadderGame;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderApplication {
    public static void main(String[] args) {
        String participant = InputView.inputParticipant();
        int ladderHeight = InputView.inputHeight();
        LadderGame ladderGame = new LadderGame(participant, ladderHeight);
        ResultView.show(ladderGame);
    }
}
