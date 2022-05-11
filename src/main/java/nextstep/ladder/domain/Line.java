package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

  private final List<Boolean> points = new ArrayList<>();

  public Line(List<Boolean> values) {
    this.points.addAll(values);
  }

  public static Line create(int width) {
    List<Boolean> values = new ArrayList<>();
    values.add(false);
    for (int i = 1; i < width; i++) {
      values.add(checkLineByPrevious(values.get(i - 1)));
    }
    return new Line(values);
  }

  static boolean checkLineByPrevious(boolean previous) {
    if (previous) {
      return false;
    }
    return getRandomBoolean();
  }

  private static boolean getRandomBoolean() {
    return Math.random() < 0.5;
  }

  public int size() {
    return points.size();
  }

  public List<Boolean> getPoints() {
    return points;
  }
}
