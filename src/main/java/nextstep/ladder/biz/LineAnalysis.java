package nextstep.ladder.biz;

public class LineAnalysis {

  public static void stat(Line selectableLine, Chessmen chessmen) {
    if (isSelectableLine(selectableLine)) {
      throw new IllegalArgumentException("Line selectableLine 을 사용하세요.");
    }

    selectableLine.getPoints().stream()
            .filter(Point::hasPoint)
            .findFirst()
            .ifPresent(point -> point.move(chessmen));
  }

  private static boolean isSelectableLine(Line line) {
    return line.getPoints().size() != 1 && line.getPoints().size() != 2;
  }
}
