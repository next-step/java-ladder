package ladder;

import ladder.domain.Ladder;
import ladder.domain.People;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderController {

    public static void main(String[] args) {
        People people= InputView.getPersonNames();
        Ladder ladder = InputView.getLadderHeight();
        ladder.generateLadder(people);

        ResultView.showLadder(people, ladder);
    }

}
