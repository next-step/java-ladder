package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import ladder.domain.strategy.NextPointGenerationStrategy;

public class Line {

  private final List<Boolean> points;

  public Line(int numberOfParticipants, NextPointGenerationStrategy generationStrategy) {
    this.points = new ArrayList<>();
    boolean previousConnected = false;

    for (int j = 0; j < numberOfParticipants - 1; j++) {
      if (!previousConnected && generationStrategy.nextBoolean()) {
        points.add(true);
        previousConnected = true;
      } else {
        points.add(false);
        previousConnected = false;
      }
    }
  }

  public List<Boolean> getPoints() {
    return points;
  }
}
