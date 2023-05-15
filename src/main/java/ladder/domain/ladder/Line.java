package ladder.domain.ladder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import ladder.domain.strategy.NextPointGenerationStrategy;

public class Line {

  private final List<Boolean> points;

  private Line(List<Boolean> points) {
    this.points = points;
  }

  Line(Boolean... points) {
    this.points = List.of(points);
  }

  public static Line createLine(int numberOfParticipants,
      NextPointGenerationStrategy generationStrategy) {
    List<Boolean> booleans = Stream.iterate(generationStrategy.first(),
            generationStrategy::nextBoolean)
        .limit(numberOfParticipants - 1)
        .collect(Collectors.toList());

    return new Line(booleans);
  }


  public List<Boolean> getPoints() {
    return points;
  }

  public boolean isRightConnected(int index) {
    if (isLastIndex(index)) {
      return false;
    }
    return points.get(index);
  }

  private boolean isLastIndex(int index) {
    return index == points.size();
  }

  public boolean isLeftConnected(int index) {
    if (isFirstIndex(index)) {
      return false;
    }
    return points.get(index - 1);
  }

  private static boolean isFirstIndex(int indexOfResult) {
    return indexOfResult == 0;
  }
}
