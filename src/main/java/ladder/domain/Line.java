package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import ladder.domain.strategy.NextPointGenerationStrategy;

public class Line {

  private final List<Boolean> points;

  private Line(List<Boolean> points) {
    this.points = points;
  }

  public static Line createLine(int numberOfParticipants, NextPointGenerationStrategy generationStrategy) {
    List<Boolean> points = new ArrayList<>();
    boolean previousConnectionStatus = false;

    for (int i = 0; i < numberOfParticipants - 1; i++) {
      previousConnectionStatus = decideNextConnectionStatus(previousConnectionStatus, generationStrategy);
      points.add(previousConnectionStatus);
    }

    return new Line(points);
  }

  private static boolean decideNextConnectionStatus(boolean previousConnectionStatus, NextPointGenerationStrategy generationStrategy) {
    return !previousConnectionStatus && generationStrategy.nextBoolean();
  }

  public List<Boolean> getPoints() {
    return points;
  }
}
