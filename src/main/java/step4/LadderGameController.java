package step4;

import java.util.List;
import step4.domain.LadderResult;
import step4.domain.column.LadderColumn;
import step4.view.ResultView;
import step4.domain.Ladder;
import step4.domain.LadderHeight;
import step4.view.InputView;

public class LadderGameController {

    public static void run() {
        LadderResult ladderResult = new LadderResult();
        ladderResult.addStartNames(new LadderColumn(InputView.requireUserName()));
        ladderResult.addResultNames(new LadderColumn(InputView.requireResultNames()));
        ladderResult.matchNameSize();

        LadderHeight height = new LadderHeight(InputView.requireHeight());
        Ladder ladder = Ladder.init(height.value(), ladderResult.sizeOfPerson());
        ladderResult.addLadderResult(ladder.move(ladderResult.sizeOfPerson()));

        ResultView.printColumn(ladderResult.startNames());
        ResultView.printLadder(ladder);
        ResultView.printColumn(ladderResult.resultNames());

        showTargetResult(ladderResult);
    }

    private static void showTargetResult(LadderResult ladderResult) {
        while (true) {
            String target = InputView.requireTarget();
            ResultView.printTarget(ladderResult, target);
            if (target.equals("all")) {
                break;
            }
        }
    }
}
