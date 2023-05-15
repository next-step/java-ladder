package ladder.domain.ladder;

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

  public boolean isRightConnected(int index) {
    if(index == points.size()) {
      return false;
    }
    return points.get(index);
  }

  public boolean isLeftConnected(int index) {
    return points.get(index - 1);
  }
}
