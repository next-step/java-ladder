package nextstep.laddergame;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import nextstep.laddergame.domain.Line;

public class LineGenerator {

  private final int countOfMembers;

  public LineGenerator(int countOfMembers) {
    this.countOfMembers = countOfMembers;
  }

  public Line generate(DrawStrategy strategy) {
    List<Boolean> points = new ArrayList<>();

    IntStream.range(0, countOfMembers)
        .mapToObj(index -> drawLine(isRowContinuousTrue(points, index), strategy))
        .forEach(points::add);

    return new Line(points);
  }

  private static boolean isRowContinuousTrue(List<Boolean> points, int index) {
    return index != 0 && points.get(index - 1);
  }

  private static boolean drawLine(Boolean isRowContinuous, DrawStrategy strategy) {
    if (isRowContinuous) {
      return false;
    }
    return strategy.isLine();
  }
}
