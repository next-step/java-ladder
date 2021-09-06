package nextstep.step2.view;

import java.util.List;
import nextstep.step2.domain.GameParticipants;
import nextstep.step2.domain.Line;

public class ResertView {

  private final int DEFAULT_NAME_LENGTH = 1;
  private final String EMPTY_LINE_SYMBOLE = " ";
  private final String LADDER_CONNECT_SYMBOLE = "-";
  private final String LADDER_SYMBOLE = "|";

  public static void print(GameParticipants gameParticipants) {
    for (int i = 0; i < gameParticipants.getParticipantsSize(); i++) {
      System.out.println(gameParticipants.getParticipant(i).getParticipantName());
    }
  }

  public void printLines(GameParticipants gameParticipants, List<Line> lines) {

    int ladderWidth = getlongestParticipantsNameLength(gameParticipants);

    printParticipants(gameParticipants, ladderWidth);

    for (int i = 0; i < gameParticipants.getParticipantsSize(); i++) {
      printLine(lines.get(i), ladderWidth);
    }
  }

  private int getlongestParticipantsNameLength(GameParticipants gameParticipants) {
    int longestNameLength = DEFAULT_NAME_LENGTH;

    for (int i = 0; i < gameParticipants.getParticipantsSize(); i++) {
      longestNameLength = getLongestNameLength(gameParticipants, longestNameLength, i);
    }

    return longestNameLength;
  }

  private int getLongestNameLength(GameParticipants gameParticipants, int longestNameLength,
      int i) {
    if (longestNameLength < gameParticipants.getParticipant(i).getParticipantName().length()) {
      longestNameLength = gameParticipants.getParticipant(i).getParticipantName().length();
    }
    return longestNameLength;
  }

  private void printLine(Line line, int ladderWidth) {

    String lineSymbol = EMPTY_LINE_SYMBOLE;
    printConnectSymbol(lineSymbol, ladderWidth);

    for (int i = 0; i < line.getPointSize(); i++) {
      System.out.print(LADDER_SYMBOLE);
      lineSymbol = getConnectSymbol(i, line);
      printConnectSymbol(lineSymbol, ladderWidth);
    }

    System.out.println(EMPTY_LINE_SYMBOLE);
  }

  private void printConnectSymbol(String lineSymbol, int ladderWidth) {
    for (int j = 0; j < ladderWidth; j++) {
      System.out.print(lineSymbol);
    }
  }

  private String getConnectSymbol(int index, Line line) {
    String connectSymbol = EMPTY_LINE_SYMBOLE;
    if (index + 1 >= line.getPointSize()) {
      return connectSymbol;
    }

    if (line.getPoint(index) && line.getPoint(index + 1)) {
      connectSymbol = LADDER_CONNECT_SYMBOLE;
    }

    return connectSymbol;
  }

  private void printParticipants(GameParticipants gameParticipants, int ladderWidth) {

    String lineSymbol = EMPTY_LINE_SYMBOLE;
    int participantsWidth = ladderWidth / 2 + 1;
    printConnectSymbol(lineSymbol, 1);
    for (int i = 0; i < gameParticipants.getParticipantsSize(); i++) {
      System.out.print(gameParticipants.getParticipant(i).getParticipantName());
      printConnectSymbol(lineSymbol, participantsWidth);
    }
    System.out.println(EMPTY_LINE_SYMBOLE);
  }
}
