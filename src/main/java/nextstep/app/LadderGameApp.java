package nextstep.app;

import nextstep.domain.*;
import nextstep.view.InputView;
import nextstep.view.OutputView;

import java.util.List;

public class LadderGameApp {

    public static void main(String[] args) {
        Participants participants = new Participants(PersonFactory.createPersons(InputView.receivePersons()));
        LadderResults ladderResults = new LadderResults(LadderResultFactory.createLadderResults(InputView.receiveLadderResults()));
        LadderHeight ladderHeight = new LadderHeight(InputView.receiveLadderHeight());
        LadderGameManager ladderGameManager = new LadderGameManager(LineFactory.createLines(participants.size(), ladderHeight.getLadderHeight()));
        OutputView.printExecuteResult(participants.getPersons(), ladderGameManager.getLines(), ladderResults.getLadderResults());
    }

}
