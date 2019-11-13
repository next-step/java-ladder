package ladder;

import ladder.game.LadderGame;
import ladder.structure.connection.RandomConnection;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderApplication {
    public static void main(String[] args) {
        String participant = InputView.inputParticipant();
        int ladderHeight = InputView.inputHeight();
        String inputResults = InputView.inputResults();
        LadderGame ladderGame = new LadderGame(participant, ladderHeight, new RandomConnection(), inputResults);
        ResultView.showLadderResult(ladderGame);
        ResultView.showResultOfParticipant(ladderGame, InputView.inputParticipantForResult());
        ResultView.showResultOfParticipant(ladderGame, InputView.inputParticipantForResult());
    }
}