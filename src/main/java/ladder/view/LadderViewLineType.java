package ladder.view;

import java.util.Arrays;

public enum LadderViewLineType {
  HORIZONTAL_FILLED_LINE(true, "-----"),
  HORIZONTAL_NORMAL_LINE(false, "     ");

  private final boolean point;
  private final String view;

  LadderViewLineType(boolean point, String view) {
    this.point = point;
    this.view = view;
  }

  public static LadderViewLineType findByPoint(boolean targetPoint) {
    return Arrays.stream(values())
      .filter(data -> data.point == targetPoint)
      .findFirst()
      .get();
  }

  public String view() {
    return view;
  }

}
