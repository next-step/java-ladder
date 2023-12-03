package nextstep.ladder;

import nextstep.ladder.controller.LadderApplication;
import nextstep.ladder.view.LadderInputView;
import nextstep.ladder.view.LadderOutputView;

public class Simulator {
    public static void main(String[] args) {
        LadderApplication ladderApplication = new LadderApplication(new LadderInputView(), new LadderOutputView());
        ladderApplication.run();
    }
}
