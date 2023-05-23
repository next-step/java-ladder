package ladder.testDouble.random;

import ladder.domain.random.RandomBooleanGenerator;

/**
 * 항상 true 만 리턴하는 랜덤 생성기
 */
public class FixedTrueOnlyRandomBooleanGenerator implements RandomBooleanGenerator {

  @Override
  public boolean getBoolean() {
    return true;
  }
}
