package ladder;

import ladder.service.LadderGame;
import ladder.common.InputMessages;
import ladder.util.StringParseUtil;
import ladder.view.InputView;
import ladder.view.ResultView;

import static ladder.service.LadderGame.COMMA;

public class Application {
    public static void main(String[] args) {
        LadderGame ladderGame = new LadderGame();

        ladderGame.setPlayer(
                StringParseUtil.splitString(InputView.showMessage(InputMessages.PLAYER_NAMES_QUESTION), COMMA));
        ladderGame.setHeight(StringParseUtil.parseToInt(InputView.showMessage(InputMessages.MAXIMUM_LADDER_HEIGHT_QUESTION)));

        ladderGame.makeLine();

        ResultView.showResultHeader();
        ResultView.showPlayers(ladderGame.getPlayers());
        ResultView.showLines(ladderGame.getLines());
    }
}
