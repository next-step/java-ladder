package laddergame;

import laddergame.domain.LadderGame;
import laddergame.domain.ParticipantName;
import laddergame.dto.LadderGameResult;
import laddergame.view.InputView;
import laddergame.view.OutputView;

import java.util.List;

public class LadderGameApplication {

    public static void main(String[] args) {
        LadderGame game = new LadderGame();
        List<ParticipantName> participantNames = InputView.inputParticipantNames();
        int ladderHeight = InputView.inputLadderHeight();

        LadderGameResult result = game.run(participantNames, ladderHeight);
        OutputView.printResult(result);
    }

}
