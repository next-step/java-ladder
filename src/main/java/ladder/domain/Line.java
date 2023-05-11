package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import ladder.domain.strategy.NextPointGenerationStrategy;

public class Line {

  private final List<Boolean> points;

  public Line(int numberOfParticipants, NextPointGenerationStrategy generationStrategy) {
    this.points = createLine(numberOfParticipants, generationStrategy);
  }

  private List<Boolean> createLine(int numberOfParticipants, NextPointGenerationStrategy generationStrategy) {
    List<Boolean> points = new ArrayList<>();
    boolean previousConnectionStatus = false;

    for (int i = 0; i < numberOfParticipants - 1; i++) {
      previousConnectionStatus = decideNextConnectionStatus(previousConnectionStatus, generationStrategy);
      points.add(previousConnectionStatus);
    }

    return points;
  }

  private boolean decideNextConnectionStatus(boolean previousConnectionStatus, NextPointGenerationStrategy generationStrategy) {
    return !previousConnectionStatus && generationStrategy.nextBoolean();
  }

  public List<Boolean> getPoints() {
    return points;
  }
}
