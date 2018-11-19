package ladder;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderController {

    public static void main(String[] args) {
        People people= InputView.getPersonNames();
        LadderResult ladderResult = new LadderResult(InputView.getResult(), people);
        Ladder ladder = InputView.getLadderHeight();
        ladder.generateLadder(people);
        ResultView.showLadder(people, ladder);

        Person person = InputView.getWantPeopleForResult();
        Result result = ladderResult.getResultForPerson(person, ladder);

        ResultView.showResult(result);

        ladder.generateLadder(people);

    }

}
