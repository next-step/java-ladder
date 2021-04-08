package ladder.domain.generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import ladder.domain.Point;

public class PointsGenerator implements Generator {

  private static final Random random = new Random();



  @Override
  public boolean generatePoint() {
    return random.nextBoolean();
  }

}
