package nextstep.ladder.src.common;

import nextstep.ladder.src.domain.Ladder;
import nextstep.ladder.src.domain.Participants;

public class ResultView {
  public static void users(Participants participants, Ui ui) {
    System.out.println(ui.participantsUi(participants));
  }

  public static void ladder(Ladder ladder, Ui ui) {
    System.out.println(ui.ladderUi(ladder));
  }
}
