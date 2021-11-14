package nextstep.ladder;

import nextstep.ladder.controller.LadderController;
import nextstep.ladder.controller.dto.LadderCreateParam;
import nextstep.ladder.doamin.Ladder;
import nextstep.ladder.doamin.fcatory.LineFactory;
import nextstep.ladder.doamin.value.Person;
import nextstep.ladder.strategy.RandomLineStrategy;
import nextstep.ladder.ui.InputView;
import nextstep.ladder.ui.ResultView;

import java.util.List;

public class LadderApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        LadderController ladderController = new LadderController(new RandomLineStrategy(), new LineFactory());

        List<Person> people = inputView.inputParticipantOfLadder();
        Integer heightOfLadder = inputView.inputHeightOfLadder();

        Ladder ladder = ladderController.createLadder(LadderCreateParam.of(people, heightOfLadder));
        resultView.printLadder(people, ladder);
    }
}
