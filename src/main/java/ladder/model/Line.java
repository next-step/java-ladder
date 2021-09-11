package ladder.model;

import java.util.List;

public class Line {

  private final List<Boolean> points;

  public Line(final List<Boolean> points) {
    this.points = points;
    validatePoints(points);
  }

  public List<Boolean> points() {
    return points;
  }

  private void validatePoints(final List<Boolean> points) {
    validateFirstPoint(points);
    for (int i = 1; i < points.size(); i++){
      validateAdjacentPoints(points.get(i - 1), points.get(i));
    }
  }

  private void validateFirstPoint(final List<Boolean> points) {
    if (points.get(0)){
      throw new IllegalArgumentException("처음부터 발판을 놓을 수 없습니다.");
    }
  }

  private void validateAdjacentPoints(final Boolean prevPoint, final Boolean point) {
    if (prevPoint && point) {
      throw new IllegalArgumentException("발판을 연속으로 놓을 수 없습니다.");
    }
  }
}
