package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderHeight;
import nextstep.ladder.domain.LadderResult;
import nextstep.ladder.domain.Players;
import nextstep.ladder.domain.Rewords;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderMain {

    public static final String ALL_RESULT = "all";

    public static void main(String[] args) {
        Players persons = InputView.inputPersons();
        LadderHeight ladderHeight = InputView.inputHeightOfLadder();
        Rewords rewords = InputView.inputResult();

        Ladder ladder = Ladder.of(persons, ladderHeight);

        ResultView.show(ladder.lines(), ladder.players());

        LadderResult ladderResult = LadderResult.of(ladder, rewords);

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
