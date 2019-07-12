package ladder;

import ladder.domain.LadderRewards;
import ladder.domain.Ladder;
import ladder.domain.LadderResults;
import ladder.domain.Players;
import ladder.domain.LadderGame;
import ladder.util.LadderGenerator;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderStart {

  private static final String STOP_KEYWORD = "all";

  public static void main(String[] args) {
    Players players = InputView.inputPlayers();
    LadderResults ladderResults = InputView.inputLadderResult(players);
    int height = InputView.inputHeight();

    Ladder ladder = LadderGenerator.generate(height, players.size());

    ResultView.view(players, ladder, ladderResults);

    LadderRewards ladderRewards =
        LadderGame.of(ladder, ladderResults).start(players);

    printResult(ladderRewards);
  }

  private static void printResult(LadderRewards ladderRewards) {
    String resultName;
    while (!STOP_KEYWORD.equalsIgnoreCase(resultName = InputView.inputResultPlayer())) {
      ResultView.resultPlayer(resultName, ladderRewards);
    }

    ResultView.resultAllPlayer(ladderRewards);
  }

}
