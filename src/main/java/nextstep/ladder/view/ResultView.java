package nextstep.ladder.view;

import java.util.List;
import java.util.Objects;
import nextstep.ladder.domain.EndPoints;
import nextstep.ladder.domain.GameResult;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Players;

public class ResultView {

  private static final String ALL = "all";
  private static final String LINE = "-----";
  private static final String NO_LINE = "     ";
  private static final String VERTICAL = "|";
  private static final String RESULT_DELIMITER = " : ";
  private static final String RIGHT_ALIGNED_FORMAT = "%6s";

  private ResultView() {}

  public static void printLadder(Players players, Ladder ladder, EndPoints endPoints) {
    System.out.println("사다리 결과");
    printRightAlignedList(players.getNames());
    System.out.println();
    drawLadder(ladder);
    printRightAlignedList(endPoints.getResults());
    System.out.println();
  }

  private static <T> void printRightAlignedList(List<T> values) {
    values.forEach(value -> System.out.printf(RIGHT_ALIGNED_FORMAT, value));
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

  public static void printResult(GameResult gameResult, String resultName) {
    if (Objects.equals(resultName, ALL)) {
      printTotalResult(gameResult);
      return;
    }
    System.out.println(resultName + RESULT_DELIMITER + gameResult.getResultByName(resultName));
  }

  private static void printTotalResult(GameResult gameResult) {
    gameResult.getResults().forEach((key, value) ->
        System.out.println(key.getName() + RESULT_DELIMITER + value)
    );
  }
}
