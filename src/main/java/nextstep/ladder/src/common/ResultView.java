package nextstep.ladder.src.common;

import nextstep.ladder.src.Ladder;
import nextstep.ladder.src.Participants;

public class ResultView {
  public static void users(Participants participants) {
    System.out.println(participants.names());
  }

  public static void ladder(Ladder ladder) {
    System.out.println(ladder.ui());
  }
}
