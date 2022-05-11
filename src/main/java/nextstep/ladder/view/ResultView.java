package nextstep.ladder.view;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Players;

public class ResultView {

  private static final String LINE = "-----";
  private static final String NO_LINE = "     ";
  private static final String VERTICAL = "|";

  private ResultView() {}

  public static void printResult(Players players, Ladder ladder) {
    System.out.println("실행 결과");
    printNames(players);
    System.out.println();
    drawLadder(ladder);
  }

  private static void printNames(Players players) {
    players.getNames().forEach(name -> System.out.printf("%6s", name));
  }

  private static void drawLadder(Ladder ladder) {
    ladder.getLines().forEach(ResultView::drawLine);
  }

  private static void drawLine(Line line) {
    line.getPoints().forEach(point -> System.out.print(getFormattedPoint(point)));
    System.out.println();
  }

  private static String getFormattedPoint(Boolean point) {
    if (point) {
      return LINE + VERTICAL;
    }
    return NO_LINE + VERTICAL;
  }
}
