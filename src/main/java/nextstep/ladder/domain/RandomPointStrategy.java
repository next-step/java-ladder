package nextstep.ladder.domain;

public class RandomPointStrategy implements PointGenerateStrategy {

  @Override
  public boolean generate() {
    return Math.random() < 0.5;
  }
}
