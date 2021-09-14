package step4;

import java.util.List;
import step4.view.ResultView;
import step4.domain.Ladder;
import step4.domain.LadderHeight;
import step4.domain.column.LadderResultColumn;
import step4.domain.column.LadderStartColumn;
import step4.view.InputView;

public class LadderGameController {

    public void run() {
        LadderStartColumn startNames = new LadderStartColumn(InputView.requireUserName());
        LadderResultColumn resultNames = new LadderResultColumn(InputView.requireResultNames());
        startNames.match(resultNames);

        LadderHeight height = new LadderHeight(InputView.requireHeight());
        Ladder ladder = Ladder.init(height.value(), startNames.sizeOfPerson());
        List<Integer> ladderResult = ladder.move(startNames.sizeOfPerson());

        ResultView.printColumn(startNames);
        ResultView.printLadder(ladder);
        ResultView.printColumn(resultNames);

        while (true) {
            String target = InputView.requireTarget();
            ResultView.printTarget(ladderResult, target, startNames, resultNames);
            if (target.equals("all")) {
                break;
            }
        }


    }
}
