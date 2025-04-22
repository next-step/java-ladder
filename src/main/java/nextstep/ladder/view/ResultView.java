package nextstep.ladder.view;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderResults;
import nextstep.ladder.domain.Participants;

public class ResultView {
  public static void printLadder(Participants participants, Ladder ladder,
      LadderResults ladderResults) {
    System.out.println("사다리 결과");
    participants.printAll();
    ladder.printLadder();
    ladderResults.printAll();
  }
}
