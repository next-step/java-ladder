package nextstep.ladder;

import nextstep.ladder.controller.LadderController;
import nextstep.ladder.controller.People;
import nextstep.ladder.controller.dto.LadderCreateParam;
import nextstep.ladder.doamin.Ladder;
import nextstep.ladder.doamin.fcatory.LineFactory;
import nextstep.ladder.strategy.RandomLineStrategy;
import nextstep.ladder.ui.InputView;
import nextstep.ladder.ui.ResultView;

public class LadderApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        LadderController ladderController = new LadderController(new RandomLineStrategy(), new LineFactory());

        People people = inputView.inputParticipantOfLadder();
        Integer heightOfLadder = inputView.inputHeightOfLadder();

        Ladder ladder = ladderController.createLadder(LadderCreateParam.of(people, heightOfLadder));
        resultView.printLadder(people, ladder);
    }
}
