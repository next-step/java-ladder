package nextstep.laddergame;

import nextstep.laddergame.domain.LadderGame;
import nextstep.laddergame.view.InputView;
import nextstep.laddergame.view.OutputView;

public class LadderGameInterface {
    public static void main(String[] args) {
        LadderGameInterface gameInterface = new LadderGameInterface();
        gameInterface.start();
    }

    public void start() {
        OutputView.printGameResult(LadderGame.start(
                InputView.enterParticipantsName(),
                InputView.enterLadderMaxHeight()));
    }

}
