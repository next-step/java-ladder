package ladder;

import java.io.IOException;
import java.util.List;
import ladder.domain.ladder.LadderGame;
import ladder.domain.ladder.player.LadderGamePlayerInfo;
import ladder.domain.ladder.reward.LadderGameRewardInfo;
import ladder.domain.ladder.setting.LadderGameSetting;
import ladder.domain.player.DefaultPlayerGenerator;
import ladder.domain.player.PlayerGenerator;
import ladder.domain.result.LadderGameResult;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderGameApplication {

  private static final String END_COMMAND = "끝";
  private static final String SEARCH_ALL_COMMAND = "all";

  public static void main(String[] args) throws IOException {
    InputView inputView = new InputView();
    ResultView resultView = new ResultView();

    final PlayerGenerator playerGenerator = DefaultPlayerGenerator.getInstance();
    final List<String> playerName = inputView.getPlayerName();
    final LadderGamePlayerInfo playerInfo = playerGenerator.generatePlayerList(playerName);

    final List<String> rewards = inputView.getRewards();
    final LadderGameRewardInfo rewardInfo = new LadderGameRewardInfo(rewards);

    int ladderHeight = inputView.ladderHeight();
    LadderGameSetting gameSetting = new LadderGameSetting();

    LadderGame game = new LadderGame(playerName.size(), ladderHeight, gameSetting);

    resultView.printPlayers(playerInfo);
    resultView.printLadders(game.getLadder());

    LadderGameResult playResult = game.play(playerInfo, rewardInfo);

    String resultUserName;

    while(!END_COMMAND.equals(resultUserName = inputView.getResultUserName())) {
      if(SEARCH_ALL_COMMAND.equals(resultUserName)) {
        resultView.showAllRewardResult(playResult);
        continue;
      }
      resultView.showRewardResult(playResult, resultUserName);
    }
    inputView.tearDown();
  }
}
