package ladder;

import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderGameLauncher {
  private static final String ALL_PLAYERS_WORD = "all";

  public static void start() {
    LadderGameInformation ladderGameInformation = InputView.askLadderGameInformation();

    Ladder ladder = new LadderGame(ladderGameInformation).makeLadder();
    String playersName = ladderGameInformation.getLengthFormatPlayersName();
    String ladderResult = ladderGameInformation.getLadderResult();

    OutputView.printPlayersName(playersName);
    OutputView.printLadder(ladder.draw());
    OutputView.printLadderResults(ladderResult);

    String playerName = InputView.askResultOfPlayer();
    if(ALL_PLAYERS_WORD.equals(playerName)) {
      LadderGameResult gameResult = ladderGameInformation.getAllPlayerResult(ladder);
      OutputView.printAllPlayerResult(gameResult.getGameResult());
      return;
    }
    int resultIndex = ladder.move(ladderGameInformation.getPlayerPosition(playerName));
    String gameResult = ladderGameInformation.getLadderResult(resultIndex);
    OutputView.printSoloResult(gameResult);


  }

  public static void main(String[] args) {
    LadderGameLauncher.start();
  }

}
