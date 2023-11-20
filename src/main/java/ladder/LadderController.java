package ladder;

import ladder.domain.Ladder;
import ladder.domain.Names;
import ladder.stretagy.RandomPointStrategy;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.List;

public class LadderController {

    public static void main(String[] args) {
        List<String> memberNames = InputView.requestJoinMembers();
        int totalLineCount = InputView.requestTotalLines();

        Names names = new Names(memberNames);
        Ladder ladder = new Ladder(totalLineCount, names.countJoinMembers(), new RandomPointStrategy());

        OutputView.printLadder(names, ladder);
    }
}
