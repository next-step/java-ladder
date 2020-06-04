package ladder;

import ladder.domain.LineList;
import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.view.InputView;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        String[] peopleNames = InputView.askingPeopleName();
        int ladderHeight = InputView.askingLadderMaxHeight();

        Ladder ladderCreator = new Ladder(peopleNames, ladderHeight);
        LineList ladder = ladderCreator.createLadder();

        List<Line> lineList = ladder.getLineList();

    }
}
