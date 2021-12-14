package domain.strategy;

import java.util.Random;

public class RandomHorizontalLineDrawingStrategy implements HorizontalLineDrawingStrategy {

  private static final Random random = new Random();

  public boolean draw() {
    return random.nextBoolean();
  }

}
