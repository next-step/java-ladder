package nextstep.ladder.domain;

import java.util.HashMap;
import java.util.Map;

public class Point {
  private Boolean point;

  private static final Map<Boolean, Point> POINTS = new HashMap<>();

  static {
    POINTS.put(Boolean.TRUE, new Point(Boolean.TRUE));
    POINTS.put(Boolean.FALSE, new Point(Boolean.FALSE));
  }

  private Point(Boolean point) {
    this.point = point;
  }

  static Point of(Boolean trueFalse) {
    return POINTS.get(trueFalse);
  }

  public Boolean isNotBridge() {
    return Boolean.FALSE.equals(point);
  }
}
