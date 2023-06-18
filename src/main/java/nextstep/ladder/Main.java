package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Peoples;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class Main {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        Peoples peoples = inputView.requestPeopleName();
        Ladder ladder = inputView.requestLadderHeight();
    }
}
