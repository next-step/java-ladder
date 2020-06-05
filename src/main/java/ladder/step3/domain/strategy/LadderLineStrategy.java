package ladder.step3.domain.strategy;

import ladder.step3.domain.Direction;

public interface LadderLineStrategy {
  Direction createLine(Direction prev);
}
