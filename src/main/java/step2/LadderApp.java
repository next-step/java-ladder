package step2;

import step2.domain.*;
import step2.view.InputView;
import step2.view.ResultView;

public class LadderApp {
    public static void main(String[] args) {
        Name name = new Name(InputView.requireNameOfParticipant());
        Height height = new Height(InputView.requireHeightOfLadder());
        Results results = new Results(InputView.requireResultNames());
        Ladder ladder = new Ladder(name.getCountOfPerson(), height.getValue());

        LadderGameManager ladderGameManager = new LadderGameManager(name, results);
        ladderGameManager.runGame(height.getValue(), ladder);

        ResultView.printHeader();
        ResultView.printParticipant(name.getParticipantNames());
        ResultView.printLadderResult(ladder.getLines());
        ResultView.printResultColumn(results);
        
        String target = InputView.requestTarget();
        ResultView.printResultOfTarget(target, ladderGameManager.getLadderResults(), results);
    }
}