package ladder;

import ladder.domain.LadderGameInfo;
import ladder.domain.LadderResult;
import ladder.domain.ResultPrize;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderGameLauncher {
    public static void main(String[] args) {
        LadderGameInfo ladderGameInfo = InputView.inputParameters();
        LadderResult drawnladder = LadderGame.draw(ladderGameInfo);

        ResultView.printLadder(drawnladder);

        ResultPrize resultPrize = LadderGame.play(drawnladder);
        ResultView.printResultofPerson(resultPrize);
    }
}
