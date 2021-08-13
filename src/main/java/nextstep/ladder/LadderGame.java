package nextstep.ladder;

import nextstep.ladder.domain.LadderNames;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderGame {

    public static void main(String[] args) {
        String initPeople = InputView.initPerson();
        LadderNames ladderNames = LadderNames.of(initPeople);

        ResultView.printName(ladderNames);
    }

}
