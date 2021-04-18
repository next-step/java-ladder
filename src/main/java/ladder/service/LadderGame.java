package ladder.service;

import ladder.domain.GameHelper;
import ladder.domain.Ladder;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.List;
import java.util.Map;

public class LadderGame {
    public static void run() {
        List<String> top = InputView.getTop();
        List<String> bottom = InputView.getBottom();
        GameHelper gameHelper = new GameHelper(top, bottom);

        int height = InputView.getLadderHeight();
        Ladder ladder = Ladder.valueOf(top.size(), height);
        ResultView.printLadder(ladder, gameHelper);

        Map<String, String> gameResult = gameHelper.gameResult(ladder);
        String findResult = InputView.findResult();

        ResultView.printResult(findResult, gameResult);
    }
}
