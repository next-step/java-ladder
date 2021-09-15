package ladder.model;

import java.util.ArrayList;
import java.util.List;
import ladder.utils.RandomValueGenerator;

public class Line {

  private final List<Boolean> points;

  public Line(final List<Boolean> points) {
    this.points = points;
    validateFirstPoint(points);
    for (int i = 1; i < points.size(); i++) {
      validateAdjacentPoints(points.get(i - 1), points.get(i));
    }
  }

  public static Line randomLine(int size) {
    List<Boolean> points = new ArrayList<>();
    points.add(false);
    while (points.size() < size) {
      addRandomPoint(points);
    }
    return new Line(points);
  }

  public boolean isExistFoothold(int idx) {
    return points.get(idx);
  }

  public int getSize() {
    return points.size();
  }

  private static void addRandomPoint(List<Boolean> points) {
    if (points.get(points.size() - 1)) {
      points.add(false);
      return;
    }
    points.add(RandomValueGenerator.generateBooleanValue());
  }

  private void validateFirstPoint(final List<Boolean> points) {
    if (points.get(0)) {
      throw new IllegalArgumentException("처음부터 발판을 놓을 수 없습니다.");
    }
  }

  private void validateAdjacentPoints(final Boolean prevPoint, final Boolean point) {
    if (prevPoint && point) {
      throw new IllegalArgumentException("발판을 연속으로 놓을 수 없습니다.");
    }
  }

  public int getMovablePosition(int currentPosition) {
    if (currentPosition == points.size() - 1){
      return points.get(currentPosition) ? currentPosition - 1 : currentPosition;
    }
    if (currentPosition == 0) {
      return points.get(currentPosition + 1) ? currentPosition + 1 : currentPosition;
    }
    if (points.get(currentPosition)) {
      return currentPosition - 1;
    }
    if (points.get(currentPosition + 1)) {
      return currentPosition + 1;
    }
    return currentPosition;
  }
}
