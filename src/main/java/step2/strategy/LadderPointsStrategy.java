package step2.strategy;

public interface LadderPointsStrategy {
  boolean makeFirstPoint();

  boolean makeMiddlePoints(boolean leftPoint);

  boolean makeLastPoint();
}
