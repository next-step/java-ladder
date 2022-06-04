package nextstep.ladder.domain;

import java.util.Random;

public class RandomPointStrategy implements PointStrategy {

  private static final Random RANDOM = new Random();

  @Override
  public boolean linkable() {
    return RANDOM.nextBoolean();
  }
}
