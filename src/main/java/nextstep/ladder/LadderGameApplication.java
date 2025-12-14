package nextstep.ladder;

import java.util.List;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class LadderGameApplication {
  public static void main(String[] args){
    List<String> participants = InputView.inputParticipants();
    int maxHeight = InputView.inputMaxLadderHeight();
    Ladder ladder = new Ladder(participants.size(), maxHeight);
    OutputView.output(participants, ladder);
  }
}
