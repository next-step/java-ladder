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
    Players players = inputView.inputPlayerName();
    Height height = inputView.inputHeight();

    Ladder ladder = Ladder.from(players, height);
    outputView.printResult();
    outputView.printPlayerNames(players);
    outputView.printLine(ladder);
  }
}
