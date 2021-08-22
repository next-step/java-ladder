package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderHeight;
import nextstep.ladder.domain.Person;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;
import java.util.List;

public class LadderGame {

    public static void main(String[] args) {
        List<Person> persons = InputView.inputPersons();
        LadderHeight ladderHeight = InputView.inputHeightOfLadder();

        Ladder ladder = Ladder.of(persons, ladderHeight);

        ResultView.show(ladder.ladderHeight(), ladder.persons());
    }
}
