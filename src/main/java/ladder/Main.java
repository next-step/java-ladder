package ladder;

import ladder.domain.Ladder;
import ladder.domain.People;
import ladder.view.ResultView;

import static ladder.view.InputView.getLadderHeight;
import static ladder.view.InputView.getPersonNames;

public class Main {
    public static void main(String[] args) {
        People people= People.from(getPersonNames());
        Ladder ladder = Ladder.from(getLadderHeight());
        ladder.generateLadder(people);

        ResultView.printLadder(people, ladder);
    }
}
