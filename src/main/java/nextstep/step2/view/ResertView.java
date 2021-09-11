package nextstep.step2.view;

import java.util.List;
import nextstep.step2.domain.GameParticipants;
import nextstep.step2.domain.LadderGameEngine;
import nextstep.step2.domain.LadderGameResult;
import nextstep.step2.domain.Line;

public class ResertView {

  private final int DEFAULT_NAME_LENGTH = 1;
  private final int DEFAULT_NAME_PRINT_BLACK_LENGTH = 2;
  private final String EMPTY_LINE_SYMBOLE = " ";
  private final String LADDER_CONNECT_SYMBOLE = "-";
  private final String LADDER_SYMBOLE = "|";

  public static void print(GameParticipants gameParticipants) {
    for (int i = 0; i < gameParticipants.getParticipantsSize(); i++) {
      System.out.println(gameParticipants.getGameParticipants(i).getParticipantName());
    }
  }

  public void printLines(GameParticipants gameParticipants, List<Line> lines,
      LadderGameEngine ladderGameEngine, LadderGameResult ladderGameResult) {

    int ladderWidth = getLongestParticipantsNameLength(gameParticipants);

    printParticipants(gameParticipants, ladderWidth);

    for (int i = 0; i < gameParticipants.getParticipantsSize(); i++) {
      printLine(lines.get(i), ladderWidth);
    }

    printLadderGameResult(gameParticipants, ladderGameResult, ladderWidth);
  }

  private void printLadderGameResult(GameParticipants gameParticipants,
      LadderGameResult ladderGameResult, int ladderWidth) {

    String lineSymbol = EMPTY_LINE_SYMBOLE;
    int participantsWidth = ladderWidth / 2 + 1;
    printConnectSymbol(lineSymbol, DEFAULT_NAME_PRINT_BLACK_LENGTH);
    for (int i = 0; i < ladderGameResult.getLadderGameResultMapSize(); i++) {
      System.out
          .print(ladderGameResult.getLadderGameResult(gameParticipants.getGameParticipants(i)));
      printConnectSymbol(lineSymbol, participantsWidth);
    }
    System.out.println(EMPTY_LINE_SYMBOLE);
  }

  private int getLongestParticipantsNameLength(GameParticipants gameParticipants) {
    int longestNameLength = DEFAULT_NAME_LENGTH;

    for (int i = 0; i < gameParticipants.getParticipantsSize(); i++) {
      longestNameLength = getLongestNameLength(gameParticipants, longestNameLength, i);
    }

    return longestNameLength + DEFAULT_NAME_LENGTH;
  }

  private int getLongestNameLength(GameParticipants gameParticipants, int longestNameLength,
      int i) {
    if (longestNameLength < gameParticipants.getParticipantNameLenth(i)) {
      longestNameLength = gameParticipants.getParticipantNameLenth(i);
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

  private String getConnectSymbol(int index, Line line) {
    if (index + 1 >= line.getPointSize()) {
      return EMPTY_LINE_SYMBOLE;
    }

    if (isConnected(index, line)) {
      return LADDER_CONNECT_SYMBOLE;
    }

    return EMPTY_LINE_SYMBOLE;
  }

  private boolean isConnected(int index, Line line) {
    return line.getPoint(index) && line.getPoint(index + 1);
  }

  private void printParticipants(GameParticipants gameParticipants, int ladderWidth) {

    String lineSymbol = EMPTY_LINE_SYMBOLE;
    int participantsWidth = ladderWidth / 2 + 1;
    printConnectSymbol(lineSymbol, DEFAULT_NAME_PRINT_BLACK_LENGTH);
    for (int i = 0; i < gameParticipants.getParticipantsSize(); i++) {
      System.out.print(gameParticipants.getGameParticipants(i).getParticipantName());
      printConnectSymbol(lineSymbol, participantsWidth);
    }
    System.out.println(EMPTY_LINE_SYMBOLE);
  }

  private void printConnectSymbol(String lineSymbol, int ladderWidth) {
    StringBuilder stringBuilder = new StringBuilder();
    for (int j = 0; j < ladderWidth; j++) {
      stringBuilder.append(lineSymbol);
    }
    System.out.print(stringBuilder);
  }

  public void printLadderGameResult(LadderGameResult ladderGameResult,
      GameParticipants participant) {
    System.out.println("\n실행 결과");
    for (int i = 0; i < participant.getParticipantsSize(); i++) {
      String participantName = participant.getGameParticipants(i).getParticipantName();
      String participantGameResult = ladderGameResult
          .getLadderGameResult(participant.getGameParticipants(i));
      System.out.println(participantName + " : " + participantGameResult);
    }
    System.out.println();
  }
}
