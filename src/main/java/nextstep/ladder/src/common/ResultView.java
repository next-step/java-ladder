package nextstep.ladder.src.common;

import nextstep.ladder.src.domain.Ladder;
import nextstep.ladder.src.domain.Participants;

public class ResultView {
  public static void users(Participants participants) {
    System.out.println(Ui.participantsUi(participants));
  }

  public static void ladder(Ladder ladder) {
    System.out.println(Ui.ladderUi(ladder));
  }
}
