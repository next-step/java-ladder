package nextstep.ladder.view;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderLine;
import nextstep.ladder.domain.Players;
import nextstep.ladder.domain.PrizeSheet;
import nextstep.ladder.domain.ResultSheet;
import nextstep.ladder.domain.model.Point;
import nextstep.ladder.domain.model.Prize;

public class ResultView {

  private static final String LADDER_RESULT = "사다리 결과";
  private static final String PLAYER_RESULT_QUESTION = "결과를 보고 싶은 사람은?";
  private static final String EXECUTION_RESULT = "실행 결과";
  private static final String ALL = "all";
  private static final String NONE = "none";
  private static final String LADDER_WITH_LEG = "-----|";
  private static final String LADDER_WITHOUT_LEG = "     |";
  private static final String PRIZE_FORMAT = "%6s";
  private static final String RESULT_FORMAT = "%s : %s";
  private static final String PLAYER_FORMAT = "%6s";

  private Scanner scanner;

  public ResultView() {
    scanner = new Scanner(System.in);
  }

  public void printLadderResult(Ladder ladder, Players players) {
    printWithNewLine(LADDER_RESULT);
    printPlayers(players);
    printLadder(ladder);
  }

  public void printPlayers(Players players) {
    players.getPlayers()
        .forEach(player -> System.out.printf(PLAYER_FORMAT, player.getName()));
    System.out.println();
  }

  public void printLadder(Ladder ladder) {
    List<LadderLine> ladderLines = ladder.getLadderLines();
    ladderLines.forEach(this::printLadderLine);
    System.out.println();
  }

  private void printLadderLine(LadderLine ladderLine) {
    List<Point> points = ladderLine.getPoints();
    points.forEach(point -> {
      String ladderStep = point.hasLeftLeg() ? LADDER_WITH_LEG :LADDER_WITHOUT_LEG;
      System.out.print(ladderStep);
    });
    System.out.println();
  }

  public void printPrizeSheet(PrizeSheet prizeSheet) {
    List<Prize> prizes = prizeSheet.getPrizeSheet();
    prizes.forEach(prize -> System.out.printf(PRIZE_FORMAT, prize.getPrize()));
    System.out.println();
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
      printResultSheet(resultSheet);
      return;
    }

    System.out.println(resultSheet.checkResult(playerName).getPrize());
  }

  private void printResultSheet(ResultSheet resultSheet) {
    Map<String, Prize> results = resultSheet.getResultSheet();
    results.forEach((name, prize) -> System.out.println(
        String.format(RESULT_FORMAT, name, prize.getPrize())
    ));
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
