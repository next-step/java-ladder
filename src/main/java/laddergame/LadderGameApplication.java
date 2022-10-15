package laddergame;

import laddergame.domain.LadderGame;
import laddergame.domain.LadderGameResult;
import laddergame.domain.LadderHeight;
import laddergame.domain.ParticipantName;
import laddergame.view.InputView;
import laddergame.view.OutputView;

import java.util.List;

public class LadderGameApplication {

    public static void main(String[] args) {
        LadderGame game = new LadderGame();
        List<ParticipantName> participantNames = InputView.inputParticipantNames();
        LadderHeight height = InputView.inputHeight();

        LadderGameResult result = game.run(participantNames, height);
        OutputView.printResult(result);
    }

}
