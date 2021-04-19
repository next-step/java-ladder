package ladder.strategy;

public interface LadderPointsStrategy {
  boolean makeFirstPoint();

  boolean makeMiddlePoints(boolean leftPoint);

  boolean makeLastPoint();
}
