package ladder;

import ladder.domain.*;
import ladder.view.ResultView;

public class LadderController {

    public Ladder execute(String names, int height, String result) {
        MatchUp matchUp = new MatchUp(names, result);
        Ladder ladder = new Ladder(new BasicLadderGenerator(height, matchUp.getPeopleCount()), matchUp);
        ResultView.print(ladder);
        return ladder;
    }

    public void displayResultOfAll(Ladder ladder, String personName) {
        int resultIndex = ladder.getPersonPosition(personName);
        ResultView.printResultOfAll(ladder.getResultValue(resultIndex));
    }

    public void displayResultAll(Ladder ladder) {
        ResultView.printResult(ladder);
    }
}