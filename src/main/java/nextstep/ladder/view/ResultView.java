package nextstep.ladder.view;

import java.util.stream.Collectors;
import nextstep.ladder.Ladder;
import nextstep.ladder.Line;
import nextstep.ladder.Participants;

public class ResultView {
  private static final int NAME_WIDTH = Participants.MAX_NAME_LENGTH + 1;

  public void printTitle() {
    System.out.println("\n실행결과\n");
  }

  public void printParticipants(Participants participants) {
    participants.names().forEach(name -> System.out.printf("%-" + NAME_WIDTH + "s", name));
    System.out.println();
  }

  public void printLadder(Ladder ladder) {
    for (Line line : ladder.lines()) {
      printLine(line);
    }
  }

  private void printLine(Line line) {
    String lineStr = line.points().stream()
        .map(point -> "|" + (point ? "-----" : "     "))
        .collect(Collectors.joining());
    System.out.println(lineStr + "|");
  }
}
