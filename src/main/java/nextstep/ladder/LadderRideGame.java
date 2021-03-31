package nextstep.ladder;

import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.LadderRideResult;
import nextstep.ladder.domain.Participants;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderRideGame {

    public void start() {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        Participants participants = checkUsers(inputView.inputParticipants());
        Height height = checkHeight(inputView.inputLadderHeight());

        resultView.printResult(LadderRideResult.valueOf(participants, height));
    }

    private Height checkHeight(int inputLadderHeight) {
        return null;
    }

    private Participants checkUsers(String inputParticipants) {
        return null;
    }

}
