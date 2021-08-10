package nextstep.ladder;

import nextstep.ladder.domain.LadderNames;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderGame {
    public static void main(String[] args) {
        InputView inputView = new InputView();

        ResultView.getInstance(LadderNames.of(inputView.initPerson()), inputView.maxLadderHeight());
    }
}
