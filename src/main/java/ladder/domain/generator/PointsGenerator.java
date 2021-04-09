package ladder.domain.generator;

import java.util.Random;

public class PointsGenerator implements Generator {

  private static final Random random = new Random();

  @Override
  public boolean generatePoint() {
    return random.nextBoolean();
  }

}
