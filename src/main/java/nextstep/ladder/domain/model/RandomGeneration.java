package nextstep.ladder.domain.model;

import java.util.Random;

public class RandomGeneration implements LadderGenerationRule {

  private static RandomGeneration instance = new RandomGeneration();

  private RandomGeneration() {}

  public static RandomGeneration getInstance() {
    return instance;
  }

  @Override
  public boolean generate() {
    return new Random().nextBoolean();
  }
}
