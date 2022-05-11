package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

  private static final int START_POSITIVE_INDEX = 1;

  private final List<Boolean> points = new ArrayList<>();

  public Line(List<Boolean> values) {
    this.points.addAll(values);
  }

  public static Line create(int width, BooleanGeneratingStrategy strategy) {
    List<Boolean> values = new ArrayList<>();
    values.add(false);
    for (int i = START_POSITIVE_INDEX; i < width; i++) {
      values.add(checkLineByPrevious(values.get(i - 1), strategy));
    }
    return new Line(values);
  }

  static boolean checkLineByPrevious(boolean previous, BooleanGeneratingStrategy strategy) {
    if (previous) {
      return false;
    }
    return strategy.getBoolean();
  }

  public int size() {
    return points.size();
  }

  public List<Boolean> getPoints() {
    return points;
  }
}
