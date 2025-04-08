package nextstep.ladder;

import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderGame {
  public static void main(String[] args) {
    Participants participants = InputView.readParticipants();
    int height = InputView.readLadderHeight();

    if(height < 0 || participants.count() < 2) {
      System.out.println("사다리 높이는 0 이상이어야 하며, 참여자는 2명 이상이어야 합니다.");
      return;
    }

    Ladder ladder = LadderGenerator.generate(participants.count(), height);

    ResultView.printTitle();
    ResultView.printParticipants(participants);
    ResultView.printLadder(ladder);
  }

}
