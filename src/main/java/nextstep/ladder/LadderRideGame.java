package nextstep.ladder;

import nextstep.ladder.domain.LadderRideResult;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderRideGame {

    public void start() {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        String participants = inputView.inputParticipants();
        int height = inputView.inputLadderHeight();

        resultView.printResult(LadderRideResult.of(participants, height));
    }
}
