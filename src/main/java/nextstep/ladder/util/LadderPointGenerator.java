package nextstep.ladder.util;

public class LadderPointGenerator {

  private static final double HALF_RATE = 0.5;

  private LadderPointGenerator() {
  }

  public static boolean generateByHalfRate() {
    return Math.random() < HALF_RATE;
  }
}
