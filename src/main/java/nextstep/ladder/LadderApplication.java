package nextstep.ladder;

import nextstep.ladder.controller.LadderController;
import nextstep.ladder.controller.RunRequest;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class LadderApplication {
    public static void main(String[] args) {
        LadderController controller = new LadderController();
        OutputView.printLadderResult(controller.run(RunRequest.of(InputView.readParticipantNames(), InputView.readHeightOfLadder())));
    }
}
