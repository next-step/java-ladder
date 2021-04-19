package ladder;

import ladder.domain.Ladder;
import ladder.domain.LadderEdge;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.List;
import java.util.Map;

public class LadderMain {
    public static void main(String[] args) {
        List<String> top = InputView.getTop();
        List<String> bottom = InputView.getBottom();
        LadderEdge ladderEdge = new LadderEdge(top, bottom);

        int height = InputView.getLadderHeight();
        Ladder ladder = Ladder.valueOf(top.size(), height);
        ResultView.printLadder(ladder, ladderEdge);

        Map<String, String> gameResult = ladderEdge.gameResult(ladder);
        String findResult = InputView.findResult();

        ResultView.printResult(findResult, gameResult);
    }
}
