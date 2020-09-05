package nextstep.app;

import nextstep.domain.*;
import nextstep.view.InputView;
import nextstep.view.OutputView;

import java.util.List;

public class LadderGameApp {

    public static void main(String[] args) {
        Participants participants = new Participants(getPersons());
        LadderResults ladderResults = new LadderResults(getLadderResults());
        LadderHeight ladderHeight = new LadderHeight(getLadderHeight());
        LadderGameManager ladderGameManager = new LadderGameManager(getLines(participants, ladderHeight));
        OutputView.printExecuteResult(participants, ladderGameManager, ladderResults);
    }

    private static List<Person> getPersons() {
        return PersonFactory.createPersons(InputView.receivePersons());
    }

    private static List<LadderResult> getLadderResults() {
        return LadderResultFactory.createLadderResults(InputView.receiveLadderResults());
    }

    private static int getLadderHeight() {
        return InputView.receiveLadderHeight();
    }

    private static List<Line> getLines(Participants participants, LadderHeight ladderHeight) {
        return LineFactory.createLines(participants, ladderHeight);
    }

}
