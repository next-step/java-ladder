package ladder.step4.domain.strategy;

import ladder.step4.domain.Direction;

public interface DirectionStrategy {
  Direction create(Direction prev);
}
