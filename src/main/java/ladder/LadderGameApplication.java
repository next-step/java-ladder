package ladder;

import java.io.IOException;
import java.util.List;
import ladder.domain.ladder.LadderGame;
import ladder.domain.ladder.setting.LadderGameSetting;
import ladder.domain.result.LadderGameResult;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderGameApplication {
  public static void main(String[] args) throws IOException {
    InputView inputView = new InputView();
    ResultView resultView = new ResultView();

    List<String> playerName = inputView.getPlayerName();
    List<String> rewords = inputView.getRewords();

    int ladderHeight = inputView.ladderHeight();
    LadderGameSetting gameSetting = LadderGameSetting.withDefaultSetting();

    LadderGame game = new LadderGame(playerName, rewords, ladderHeight, gameSetting);

    resultView.printPlayers(game.getPlayerInfo());
    resultView.printLadders(game.getLadder());
    LadderGameResult playResult = game.play();

    while(true) {
      String resultUserName = inputView.getResultUserName();

      if("끝".equals(resultUserName)) {
        break;
      }

      if("all".equals(resultUserName)) {
        resultView.showAllRewordResult(playResult);
      }

      resultView.showRewordResult(playResult, resultUserName);
    }

    inputView.tearDown();
  }
}
