package nextstep.ladder.domain.dimension;

import java.util.HashMap;
import java.util.Map;

public class Point {

  private static final Map<Boolean, Point> POINTS = new HashMap<>();

  static {
    POINTS.put(Boolean.TRUE, new Point(true));
    POINTS.put(Boolean.FALSE, new Point(false));
  }

  private boolean point;


  private Point(boolean point) {
    this.point = point;
  }

  public static Point of(Boolean trueFalse) {
    return POINTS.get(trueFalse);
  }

  public Boolean isNotBridge() {
    return !point;
  }
}
