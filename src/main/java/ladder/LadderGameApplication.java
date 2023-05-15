package ladder;

import java.io.IOException;
import java.util.List;
import ladder.domain.LadderGame;
import ladder.domain.ladder.DefaultLadderGenerator;
import ladder.domain.ladder.LadderGenerator;
import ladder.domain.ladder.setting.LadderGameSetting;
import ladder.domain.player.DefaultPlayerGenerator;
import ladder.domain.player.PlayerGenerator;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderGameApplication {
  public static void main(String[] args) throws IOException {
    InputView inputView = new InputView();
    ResultView resultView = new ResultView();

    List<String> playerName = inputView.getPlayerName();
    int ladderHeight = inputView.ladderHeight();

    LadderGameSetting gameSetting = LadderGameSetting.builder()
        .ladderGenerator(new DefaultLadderGenerator())
        .playerGenerator(new DefaultPlayerGenerator())
        .build();

    LadderGame game = new LadderGame(playerName, ladderHeight, gameSetting);

    resultView.printPlayers(game.getPlayers());
    resultView.printLadders(game.getLadderLines());
    game.play();

    inputView.tearDown();
  }
}
