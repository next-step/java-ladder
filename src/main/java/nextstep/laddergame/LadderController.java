package nextstep.laddergame;

import java.io.IOException;
import nextstep.laddergame.domain.Ladder;
import nextstep.laddergame.domain.Members;
import nextstep.laddergame.ui.InputView;
import nextstep.laddergame.ui.OutputView;

public class LadderController {

  public LadderController() throws IOException {
    Ladder ladder = initPhase();
    resultPhase(ladder);
  }

  public static void startLadderGame() throws IOException {
    new LadderController();
  }

  private Ladder initPhase() throws IOException {
    Members members = getMembers();
    return Ladder.createLadder(getLadderHeight(), members);
  }

  private void resultPhase(Ladder ladder) {
    new OutputView().printLadder(ladder);
  }

  private int getLadderHeight() throws IOException {
    return new InputView().enteredLadderHeight();
  }

  private Members getMembers() throws IOException {
    return new InputView().enteredUserNames();
  }
}
