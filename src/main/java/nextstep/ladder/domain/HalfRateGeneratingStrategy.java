package nextstep.ladder.domain;

public class HalfRateGeneratingStrategy implements BooleanGeneratingStrategy {

  private static final double HALF_RATE = 0.5;
  private static final HalfRateGeneratingStrategy STRATEGY = new HalfRateGeneratingStrategy();

  private HalfRateGeneratingStrategy() {
  }

  public static HalfRateGeneratingStrategy getInstance() {
    return STRATEGY;
  }

  @Override
  public boolean getBoolean() {
    return Math.random() < HALF_RATE;
  }
}
