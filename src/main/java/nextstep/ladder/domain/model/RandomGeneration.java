package nextstep.ladder.domain.model;

import java.util.Random;

public class RandomGeneration implements LadderGenerationRule {

  private static RandomGeneration instance;

  public RandomGeneration() {}

  public static RandomGeneration getInstance() {
    if (instance == null) {
      instance = new RandomGeneration();
    }

    return instance;
  }

  @Override
  public boolean generate() {
    return new Random().nextBoolean();
  }
}
