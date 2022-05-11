package nextstep.ladder.domain;

public class HalfBooleanGeneratingStrategy implements BooleanGeneratingStrategy {

  private static final double HALF_RATE = 0.5;
  private static final HalfBooleanGeneratingStrategy STRATEGY = new HalfBooleanGeneratingStrategy();

  private HalfBooleanGeneratingStrategy() {
  }

  public static HalfBooleanGeneratingStrategy getInstance() {
    return STRATEGY;
  }

  @Override
  public boolean getBoolean() {
    return Math.random() < HALF_RATE;
  }
}
