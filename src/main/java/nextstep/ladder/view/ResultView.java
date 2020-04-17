package nextstep.ladder.view;

import java.util.Scanner;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Players;
import nextstep.ladder.domain.ResultSheet;

public class ResultView {

  private static final String LADDER_RESULT = "사다리 결과";
  private static final String PLAYER_RESULT_QUESTION = "결과를 보고 싶은 사람은?";
  private static final String EXECUTION_RESULT = "실행 결과";
  private static final String ALL = "all";
  private static final String NONE = "none";

  private Scanner scanner;

  public ResultView() {
    scanner = new Scanner(System.in);
  }

  public void printLadderResult(Ladder ladder, Players players) {
    printWithNewLine(LADDER_RESULT);
    players.print();
    ladder.print();
  }

  public void printWinningResult(ResultSheet resultSheet) {
    String playerName = getPlayerName();

    while (!playerName.equals(NONE)) {
      printResultByName(resultSheet, playerName);

      playerName = getPlayerName();
    }
  }

  private void printResultByName(ResultSheet resultSheet, String playerName) {
    printWithNewLine(EXECUTION_RESULT);
    if (playerName.equals(ALL)) {
      resultSheet.print();
      return;
    }

    System.out.println(resultSheet.checkResult(playerName).getPrize());
  }

  private String getPlayerName() {
    printWithNewLine(PLAYER_RESULT_QUESTION);
    return scanner.nextLine();
  }

  private void printWithNewLine(String sentence) {
    System.out.println();
    System.out.println(sentence);
  }
}
