package nextstep.laddergame;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Stream;
import nextstep.laddergame.domain.Line;

public class LineGenerator {

  private final int countOfMembers;

  public LineGenerator(int countOfMembers) {
    this.countOfMembers = countOfMembers;
  }

  public Line generate(DrawStrategy strategy) {
    return Stream.generate(strategy::isLine)
        .limit(countOfMembers)
        .collect(Collector.of(ProtoLine::new,
                              ProtoLine::add,
                              ProtoLine::merge,
                              ProtoLine::toLine));
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
