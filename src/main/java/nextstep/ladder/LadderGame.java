package nextstep.ladder;

import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderGame {
  public static void main(String[] args) {
    Participants participants = InputView.readParticipants();
    int height = InputView.readLadderHeight();

    Ladder ladder = LadderGenerator.generate(participants.count(), height);

    ResultView.printTitle();
    ResultView.printParticipants(participants);
    ResultView.printLadder(ladder);
  }

}
