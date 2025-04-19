package nextstep.ladder.view;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Participants;

public class ResultView {
  public static void printResult(Participants participants, Ladder ladder) {
    System.out.println("실행결과");
    participants.printAll();
    ladder.printLadder();
  }
}
