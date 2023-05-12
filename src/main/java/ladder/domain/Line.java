package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import ladder.domain.strategy.NextPointGenerationStrategy;

public class Line {

  private final List<Boolean> points;

  private Line(List<Boolean> points) {
    this.points = points;
  }

  public static Line createLine(int numberOfParticipants, NextPointGenerationStrategy generationStrategy) {
    List<Boolean> points = new ArrayList<>();

    for (int i = 0; i < numberOfParticipants - 1; i++) {
      boolean previousConnectionStatus = decideNextConnectionStatus(previousConnectionStatus(i, points), generationStrategy);
      points.add(previousConnectionStatus);
    }

    return new Line(points);
  }

  private static boolean previousConnectionStatus(int i, List<Boolean> points) {
    if (i == 0) {
      return false;
    }
    return points.get(i-1);
  }

  private static boolean decideNextConnectionStatus(boolean previousConnectionStatus, NextPointGenerationStrategy generationStrategy) {
    return !previousConnectionStatus && generationStrategy.nextBoolean();
  }

  public List<Boolean> getPoints() {
    return points;
  }
}
