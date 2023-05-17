package ladder.domain.ladder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import ladder.domain.strategy.NextPointGenerationStrategy;

public class Line {

  private final List<Boolean> points;

  private Line(List<Boolean> points) {
    validateNotContinuous(points);
    this.points = points;
  }

  private void validateNotContinuous(List<Boolean> points) {
    IntStream.range(0, points.size() - 1)
        .filter(i -> points.get(i) && points.get(i + 1))
        .findAny()
        .ifPresent(i -> {
          throw new IllegalArgumentException("연속된 true 값이 존재합니다.");
        });
  }

  Line(Boolean... points) {
    this(List.of(points));
  }

  public static Line createLine(int numberOfParticipants,
      NextPointGenerationStrategy generationStrategy) {
    int limitsOfGeneration = numberOfParticipants - 1;
    List<Boolean> booleans = Stream.iterate(generationStrategy.first(), generationStrategy::nextBoolean)
        .limit(limitsOfGeneration)
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
