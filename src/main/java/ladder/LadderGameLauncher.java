package ladder;

import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderGameLauncher {

  public static void start() {
    LadderGameInformation ladderGameInformation = InputView.askLadderGameInformation();

    Ladder ladder = new LadderGame(ladderGameInformation).makeLadder();
    String playersName = ladderGameInformation.getLengthFormatPlayersName();

    OutputView.printPlayersName(playersName);
    OutputView.printLadder(ladder.draw());

  }

  public static void main(String[] args) {
    LadderGameLauncher.start();
  }

}
