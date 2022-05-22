package nextstep.ladder.view;

import java.util.Objects;
import nextstep.ladder.domain.GameResult;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Player;
import nextstep.ladder.domain.Players;
import nextstep.ladder.domain.EndPoints;

public class ResultView {

  private static final String LINE = "-----";
  private static final String NO_LINE = "     ";
  private static final String VERTICAL = "|";

  private ResultView() {}

  public static void printLadder(Players players, Ladder ladder, EndPoints endPoints) {
    System.out.println("사다리 결과");
    printNames(players);
    System.out.println();
    drawLadder(ladder);
    printEndPoints(endPoints);
    System.out.println();
  }

  private static void printNames(Players players) {
    players.getNames().forEach(name -> System.out.printf("%6s", name));
  }

  private static void drawLadder(Ladder ladder) {
    ladder.getLines().forEach(ResultView::drawLine);
  }

  private static void printEndPoints(EndPoints endPoints) {
    endPoints.getResults().forEach(result -> System.out.printf("%6s", result));
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

  public static void printResult(GameResult gameResult, String resultName) {
    System.out.println("실행 결과");
    if (Objects.equals(resultName, "all")) {
      gameResult.getResults()
          .forEach((key, value) -> System.out.println(key.getName() + " : " + value));
      return;
    }
    System.out.println(gameResult.getResults().get(Player.of(resultName)));
  }
}
