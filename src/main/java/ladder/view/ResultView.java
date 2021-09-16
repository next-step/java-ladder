package ladder.view;

import java.util.List;
import ladder.model.LadderGame;

public class ResultView {

  private static final int FOOT_HOLD_WIDTH = 5;
  private static final char LADDER_STICK_CHAR = '|';
  private static final char FOOT_HOLD_CHAR = '-';
  private static final char NO_FOOT_HOLD_CHAR = ' ';

  public static void printLadderResult(LadderGame ladderGame) {
    System.out.println("\n사다리 결과\n");
    printAccordingToFootHoldWidth(ladderGame.getParticipants());
    for (int height = 0; height < ladderGame.getLadderHeight(); height++) {
      printLadderLine(ladderGame, height);
    }
    printAccordingToFootHoldWidth(ladderGame.getResults());
  }

  public static void printLadderGameResult(LadderGame ladderGame, String participant) {
    System.out.println("\n실행 결과");
    if (!participant.equals("all")) {
      System.out.println(ladderGame.getResultByParticipant(participant));
      return;
    }
    printAllLadderGameResult(ladderGame);
  }

  private static void printAccordingToFootHoldWidth(List<String> stringList) {
    stringList.forEach(s -> System.out.printf("%" + (ResultView.FOOT_HOLD_WIDTH + 1) + "s", s));
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

  private static void printAllLadderGameResult(LadderGame ladderGame) {
    List<String> participants = ladderGame.getParticipants();
    participants.forEach(participant -> {
      String result = ladderGame.getResultByParticipant(participant);
      System.out.println(participant + " : " + result);
    });
  }
}
