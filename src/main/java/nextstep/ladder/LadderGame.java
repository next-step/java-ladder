package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderHeight;
import nextstep.ladder.domain.LadderResult;
import nextstep.ladder.domain.Persons;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;
import java.util.List;

public class LadderGame {

    public static final String ALL_RESULT = "all";

    public static void main(String[] args) {
        Persons persons = InputView.inputPersons();
        LadderHeight ladderHeight = InputView.inputHeightOfLadder();
        List<String> results = InputView.inputResult();

        Ladder ladder = Ladder.of(persons, ladderHeight);

        ResultView.show(ladder.lines(), ladder.persons());

        LadderResult ladderResult = LadderResult.of(ladder, results);

        while (true) {
            String name = InputView.inputWantPerson();

            if (name.equals(ALL_RESULT)) {
                ResultView.results(ladderResult, persons);
                break;
            }

            ResultView.result(ladderResult, name);
        }

    }
}
