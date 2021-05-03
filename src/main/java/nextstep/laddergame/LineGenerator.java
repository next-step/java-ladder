package nextstep.laddergame;

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
}
