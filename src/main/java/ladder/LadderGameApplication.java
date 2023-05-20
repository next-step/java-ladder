package ladder;

import java.io.IOException;
import java.util.List;
import ladder.domain.ladder.LadderGame;
import ladder.domain.ladder.player.LadderGamePlayerInfo;
import ladder.domain.ladder.reword.LadderGameRewordInfo;
import ladder.domain.ladder.setting.LadderGameSetting;
import ladder.domain.player.DefaultPlayerGenerator;
import ladder.domain.player.PlayerGenerator;
import ladder.domain.result.LadderGameResult;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderGameApplication {
  public static void main(String[] args) throws IOException {
    InputView inputView = new InputView();
    ResultView resultView = new ResultView();

    final PlayerGenerator playerGenerator = new DefaultPlayerGenerator();
    final List<String> playerName = inputView.getPlayerName();
    final LadderGamePlayerInfo playerInfo = playerGenerator.generatePlayerList(playerName);

    final List<String> rewords = inputView.getRewords();
    final LadderGameRewordInfo rewordInfo = new LadderGameRewordInfo(rewords);

    int ladderHeight = inputView.ladderHeight();
    LadderGameSetting gameSetting = LadderGameSetting.withDefaultSetting();

    LadderGame game = new LadderGame(playerName.size(), ladderHeight, gameSetting);

    resultView.printPlayers(playerInfo);
    resultView.printLadders(game.getLadder());

    LadderGameResult playResult = game.play(playerInfo, rewordInfo);

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
