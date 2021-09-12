package ladder.view;

import java.util.List;
import ladder.model.Ladder;
import ladder.model.LadderGame;
import ladder.model.Line;

public class ResultView {

  private static final int FOOT_HOLD_WIDTH = 5;
  private static final char LADDER_STICK_CHAR = '|';
  private static final char FOOT_HOLD_CHAR = '-';
  private static final char NO_FOOT_HOLD_CHAR = ' ';

  public static void printResult(LadderGame ladderGame) {
    System.out.println("\n실행결과\n");

    printParticipants(ladderGame.participants());
    printLadder(ladderGame.ladder());
  }

  private static void printParticipants(List<String> participants) {
    participants.forEach(s -> System.out.printf("%" + (FOOT_HOLD_WIDTH + 1) + "s", s));
    System.out.println();
  }

  private static void printLadder(Ladder ladder) {
    for (Line line : ladder.lines()) {
      printLine(line);
    }
  }

  private static void printLine(Line line) {
    for (Boolean point : line.points()) {
      printFootHold(point);
      System.out.print(LADDER_STICK_CHAR);
    }
    System.out.println();
  }

  private static void printFootHold(Boolean point) {
    char printChar = point ? FOOT_HOLD_CHAR : NO_FOOT_HOLD_CHAR;
    for (int i = 0; i < FOOT_HOLD_WIDTH; i++) {
      System.out.print(printChar);
    }
  }
}
