package ladder.step2.view;

import ladder.step2.domain.Ladder;
import ladder.step2.domain.LadderLine;
import ladder.step2.domain.Participants;

import java.util.Scanner;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;

public class ResultView {
  private static final ResultView instance = new ResultView();
  private static final String IS_LINE = "-----|";
  private static final String NO_LINE = "     |";

  private ResultView () { }

  public void viewLadder (Ladder ladder, Participants participants) {
    System.out.printf(
      "\n실행결과\n%s\n%s",
      toStringOfParticipants(participants),
      toStringOfLadder(ladder)
    );
  }

  private String toStringOfParticipants (Participants participants) {
    return participants.stream()
                       .map(participant -> String.format("%5s", participant))
                       .collect(joining(""));
  }

  private static String toStringOfLadder (Ladder ladder) {
    return ladder.stream()
                 .map(ResultView::toStringOfLadderLine)
                 .collect(joining("\n"));
  }

  private static String toStringOfLadderLine (LadderLine ladderLine) {
    return String.format(
      NO_LINE,
      ladderLine.stream()
        .map(v -> v ? IS_LINE : NO_LINE)
        .collect(joining(""))
    );
  }


  public static ResultView getInstance() {
    return instance;
  }

}
