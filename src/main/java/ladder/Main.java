package ladder;

import ladder.domain.LineList;
import ladder.domain.Ladder;
import ladder.view.InputView;
import ladder.view.ResultVIew;

public class Main {

    public static void main(String[] args) {
        String[] peopleNames = InputView.askingPeopleName();
        int ladderHeight = InputView.askingLadderMaxHeight();

        Ladder ladder = new Ladder(peopleNames, ladderHeight);
        LineList lineList = ladder.createLadder();

        ResultVIew.printLadder(peopleNames, lineList.getLineList());
    }
}
