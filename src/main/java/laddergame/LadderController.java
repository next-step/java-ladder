package laddergame;

import laddergame.domain.Ladder;
import laddergame.domain.Participates;
import laddergame.view.InputView;
import laddergame.view.OutputView;

public class LadderController {

    LadderGame game = new LadderGame();
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void gameStart() {
        Participates participates = new Participates(inputView.inputParticipate());
        int height = inputView.inputMaxLadderHeight();
        Ladder ladder = game.createLadder(participates, height);
        outputView.showParticipate(participates);
        outputView.showLadder(ladder);

    }
}
