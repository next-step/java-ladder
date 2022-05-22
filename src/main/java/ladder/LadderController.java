package ladder;

import view.LadderInputView;
import view.LadderOutputView;

public class LadderController {

  private final LadderInputView inputView;
  private final LadderOutputView outputView;

  public LadderController() {
    inputView = new LadderInputView();
    outputView = new LadderOutputView();
  }

  public void proceed() {
    PlayerNames playerNames = inputView.inputPlayerName();
    PlayerNumber playerNumber = PlayerNumber.from(playerNames);
    Height height = inputView.inputHeight();

    Ladder ladder = Ladder.from(playerNumber, height);
    outputView.printResult();
    outputView.printPlayerNames(playerNames);
    outputView.printLine(ladder);
  }
}
