package ladder;

import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderGameLauncher {

  private static final String ALL_PLAYERS_WORD = "all";

  public static void start() {
    LadderGameInformation ladderGameInformation = InputView.askLadderGameInformation();
    LadderGame ladderGame = new LadderGame(ladderGameInformation);

    Ladder ladder = ladderGame.makeLadder();
    LadderResult ladderResult = new LadderResult(InputView.askLadderResult(),ladderGameInformation.playersCount());

    OutputView.printPlayersName(ladderGameInformation.getLengthFormatPlayersName());
    OutputView.printLadder(ladder.draw());
    OutputView.printLadderResults(ladderResult);

    String playerName = InputView.askResultOfPlayer();
    if (ALL_PLAYERS_WORD.equals(playerName)) {
      LadderGameResult gameResult = ladderGame.getAllPlayerResult(ladderResult);
      OutputView.printAllPlayerResult(gameResult.getGameResult());
      return;
    }
    int resultIndex = ladder.move(ladderGameInformation.getPlayerPosition(playerName));
    String gameResult = ladderResult.getLadderResult(resultIndex);
    OutputView.printSoloResult(gameResult);
  }

  public static void main(String[] args) {
    LadderGameLauncher.start();
  }

}
