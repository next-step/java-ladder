package nextstep.ladder.src.common;

import nextstep.ladder.src.Ladder;
import nextstep.ladder.src.Participants;
import nextstep.ladder.src.Ui;

public class ResultView {
  public static void users(Participants participants, Ui ui) {
    System.out.println(ui.participantsUi(participants));
  }

  public static void ladder(Ladder ladder, Ui ui) {
    System.out.println(ui.ladderUi(ladder));
  }
}
