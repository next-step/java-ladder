package step4;

import step2.view.ResultView;
import step4.domain.Ladder;
import step4.domain.LadderHeight;
import step4.domain.LadderResultColumn;
import step4.domain.LadderStartColumn;
import step4.view.InputView;

public class LadderGameController {
    public void run() {
        LadderStartColumn startNames = new LadderStartColumn(InputView.requireUserName());
        LadderResultColumn resultNames = new LadderResultColumn(InputView.requireResultNames());

        LadderHeight height = new LadderHeight(InputView.requireHeight());
        Ladder ladder = Ladder.init(height.value(), startNames.sizeOfPerson());


        ResultView.printColumn(startNames);
        ResultView.printColumn(resultNames);
    }
}
