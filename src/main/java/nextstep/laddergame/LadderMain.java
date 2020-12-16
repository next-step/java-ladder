package nextstep.laddergame;

import nextstep.laddergame.controller.LadderController;
import nextstep.laddergame.view.InputView;
import nextstep.laddergame.view.ResultView;

public class LadderMain {
    private InputView inputView;
    private ResultView resultView;
    private LadderController ladderController;

    public LadderMain() {
        this.inputView = new InputView();
        this.resultView = new ResultView();
        this.ladderController = new LadderController();

    }
    public void run() {
        String participants =inputView.getParticipant();
        int ladderHeight = inputView.getLadderHeight();

        ladderController.initParticipants(participants);

    }
}
