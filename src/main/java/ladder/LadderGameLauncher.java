package ladder;

import ladder.domain.LadderSetting;
import ladder.domain.LadderGameInfo;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderGameLauncher {
    public static void main(String[] args) {
        LadderSetting ladderSetting = InputView.inputParameters();
        LadderGameInfo ladderGameInfo = LadderGame.draw(ladderSetting);

        ResultView.printLadder(ladderGameInfo);
    }
}
