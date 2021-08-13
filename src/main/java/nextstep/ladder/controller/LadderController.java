package nextstep.ladder.controller;

import nextstep.ladder.domain.Names;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderController {

    public static void run() {
        String initPeople = InputView.initPeople();
        Names ladderNames = Names.of(initPeople);
        String resultName = InputView.excutionResult();

        int maxLadderHeight = InputView.maxLadderHeight();





        ResultView.printName(ladderNames);
    }

}
