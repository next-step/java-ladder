package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

  private final List<Boolean> points = new ArrayList<>();

  public Line(int width) {
    points.add(false);
    for (int i = 1; i < width; i++) {
      points.add(checkLineByPrevious(points.get(i - 1)));
    }
  }

  static boolean checkLineByPrevious(boolean previous) {
    if (Boolean.TRUE.equals(previous)) {
      return false;
    }
    return getRandomBoolean();
  }

  private static boolean getRandomBoolean() {
    return Math.random() < 0.5;
  }
}
