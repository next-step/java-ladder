package ladder;

import ladder.domain.LadderSetting;
import ladder.domain.LadderGameResult;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderGameLauncher {
    public static void main(String[] args) {
        LadderSetting ladderSetting = InputView.inputParameters();
        LadderGameResult ladderGameResult = LadderGame.draw(ladderSetting);

        ResultView.printLadder(ladderGameResult);
    }
}
