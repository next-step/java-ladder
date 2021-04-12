package nextstep.ladder.domain;

import java.util.Random;

public final class RandomLineCreationStrategy implements LineCreationStrategy {

  private final Random random = new Random();

  @Override
  public boolean canCreate() {
    return random.nextBoolean();
  }
}
