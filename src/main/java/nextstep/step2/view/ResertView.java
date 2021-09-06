package nextstep.step2.view;

import java.util.List;
import nextstep.step2.domain.GameParticipants;
import nextstep.step2.domain.Line;

public class ResertView {

  private final int LADDER_WIDTH = 5;

  public static void print(GameParticipants gameParticipants) {
    for (int i = 0; i < gameParticipants.getParticipantsSize(); i++) {
      System.out.println(gameParticipants.getParticipant(i).getParticipantName());
    }
  }

  public void printLines(GameParticipants gameParticipants, List<Line> lines) {

    printParticipants(gameParticipants);

    for (int i = 0; i < gameParticipants.getParticipantsSize(); i++) {
      printLine(lines.get(i));
    }
  }

  private void printLine(Line line) {
    System.out.print("  ");

    for (int i = 0; i < line.getPointSize(); i++) {
      System.out.print("|");
      String lineSymbol = getConnectSymbol(i, line);
      printConnectSymbol(lineSymbol);
    }

    System.out.println("|");
  }

  private void printConnectSymbol(String lineSymbol) {
    for (int j = 0; j < LADDER_WIDTH; j++) {
      System.out.print(lineSymbol);
    }
  }

  private String getConnectSymbol(int index, Line line) {
    String connectSymbol = " ";
    if (index + 1 >= line.getPointSize()) {
      return connectSymbol;
    }

    if (line.getPoint(index) && line.getPoint(index + 1)) {
      connectSymbol = "-";
    }

    return connectSymbol;
  }

  private void printParticipants(GameParticipants gameParticipants) {
    for (int i = 0; i < gameParticipants.getParticipantsSize(); i++) {
      System.out.print(gameParticipants.getParticipant(i).getParticipantName());
      System.out.print("  ");
    }
    System.out.println("  ");
  }
}
