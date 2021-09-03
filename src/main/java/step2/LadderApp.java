package step2;

import step2.domain.*;
import step2.view.InputView;
import step2.view.ResultView;

public class LadderApp {
    public static void main(String[] args) {
        Name name = new Name(InputView.requireNameOfParticipant());
        Height height = new Height(InputView.requireHeightOfLadder());
        Result result = new Result(InputView.requireResultNames());
        Ladder ladder = new Ladder(name.getCountOfPerson(), height.getValue());

        LadderGameManager ladderGameManager = new LadderGameManager(name, result);
        ladderGameManager.runGame(height.getValue(), ladder);

        ResultView.printHeader();
        ResultView.printParticipant(name.getParticipantNames());
        ResultView.printLadderResult(ladder.getLines());
        ResultView.printResultColumn(result);

        String target = InputView.requestTarget();
        ResultView.printResultOfTarget(target, ladderGameManager.getLadderGames());
    }
}