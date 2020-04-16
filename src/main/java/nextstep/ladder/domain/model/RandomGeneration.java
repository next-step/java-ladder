package nextstep.ladder.domain.model;

import java.util.Random;

public class RandomGeneration implements LadderGenerationRule {

  @Override
  public boolean generate() {
    return new Random().nextBoolean();
  }
}
