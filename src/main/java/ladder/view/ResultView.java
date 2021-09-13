package ladder.view;

import java.util.List;
import ladder.model.LadderGame;

public class ResultView {

  private static final int FOOT_HOLD_WIDTH = 5;
  private static final char LADDER_STICK_CHAR = '|';
  private static final char FOOT_HOLD_CHAR = '-';
  private static final char NO_FOOT_HOLD_CHAR = ' ';

  public static void printResult(LadderGame ladderGame) {
    System.out.println("\n실행결과\n");

    printParticipants(ladderGame.getParticipantNames());

    for (int height = 0; height < ladderGame.getLadderHeight(); height++) {
      printLadderLine(ladderGame, height);
    }
  }

  private static void printParticipants(List<String> participants) {
    participants.forEach(s -> System.out.printf("%" + (FOOT_HOLD_WIDTH + 1) + "s", s));
    System.out.println();
  }

  private static void printLadderLine(LadderGame ladderGame, int height) {
    for (int width = 0; width < ladderGame.getLadderWidth(); width++) {
      printFoothold(ladderGame.isExistFoothold(height, width));
      System.out.print(LADDER_STICK_CHAR);
    }
    System.out.println();
  }

  private static void printFoothold(Boolean isExistFoothold) {
    char printChar = isExistFoothold ? FOOT_HOLD_CHAR : NO_FOOT_HOLD_CHAR;
    for (int i = 0; i < FOOT_HOLD_WIDTH; i++) {
      System.out.print(printChar);
    }
  }
}
