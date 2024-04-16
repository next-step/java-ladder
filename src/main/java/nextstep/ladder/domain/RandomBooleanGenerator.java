package nextstep.ladder.domain;

import java.util.Random;

public class RandomBooleanGenerator implements BooleanGenerator {

  private final Random random;

  public RandomBooleanGenerator(){
    random = new Random();
  }

  @Override
  public Boolean generate() {
    return random.nextBoolean();
  }
}
