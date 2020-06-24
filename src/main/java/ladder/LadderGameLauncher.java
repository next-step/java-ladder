package ladder;

import ladder.domain.LadderGameInfo;
import ladder.domain.LadderResult;
import ladder.domain.ResultPrize;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderGameLauncher {
    public static void main(String[] args) {
        LadderGameInfo ladderGameInfo = InputView.inputParameters();
        LadderResult ladderGameResult = LadderGame.draw(ladderGameInfo);

        ResultView.printLadder(ladderGameResult);

        ResultPrize resultPrize = LadderGame.play(ladderGameResult);
        ResultView.printResultofPerson(resultPrize);
    }
}
