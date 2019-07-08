package ladder;

import ladder.impl.DefaultLadderGenerator;
import ladder.impl.LadderGameResult;
import ladder.impl.LadderHeight;
import ladder.impl.Players;
import ladder.impl.ResultProcessor;
import ladder.impl.Targets;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderGameLauncher {

  private static final String ALL_MEAN_WORD = "all";

  public static void main(String[] args) {
    LadderGameLauncher.start();
  }

  private static void start() {

    Players players = InputView.askPlayersName();
    Targets targets = InputView.askLadderTargets();
    LadderHeight ladderHeight = InputView.askLadderHeight();

    LadderGame ladderGame = LadderGame.of(new DefaultLadderGenerator());

    Ladder ladder = ladderGame.generate(players, ladderHeight);

    OutputView.printLadderResultIntro();
    OutputView.printPlayersName(players);
    OutputView.printLadder(ladder);
    OutputView.printTargets(targets);

    PlayResults results = ladder.play();
    ResultProcessor resultProcessor = ResultProcessor.of(players, targets);
    LadderGameResult ladderGameResult = resultProcessor.toResults(results);

    String playerName = InputView.askResultOfPlayer();
    if (ALL_MEAN_WORD.equals(playerName)) {
      OutputView.printAllPlayerResult(ladderGameResult.getGameResult());
      return;
    }

    OutputView.printSoloResult(ladderGameResult.getGameResult(playerName));

  }
}
