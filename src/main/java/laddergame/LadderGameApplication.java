package laddergame;

import laddergame.component.LadderFactory;
import laddergame.component.RandomLadderLineFactory;
import laddergame.domain.LadderGame;
import laddergame.dto.LadderGameResult;
import laddergame.view.InputView;
import laddergame.view.OutputView;

import java.util.List;

public class LadderGameApplication {

    public static void main(String[] args) {
        List<String> participantNames = InputView.inputParticipantNames();
        int ladderHeight = InputView.inputLadderHeight();

        LadderFactory ladderFactory = new LadderFactory(new RandomLadderLineFactory());
        LadderGame game = new LadderGame(ladderFactory);
        LadderGameResult result = game.run(participantNames, ladderHeight);
        OutputView.printResult(result);
    }

}
