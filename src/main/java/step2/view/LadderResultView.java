package step2.view;

import java.util.Arrays;

public enum LadderResultView {
  HORIZONTAL_FILLED_LINE(true, "-----"),
  HORIZONTAL_NORMAL_LINE(false, "     ");

  private final boolean point;
  private final String view;

  LadderResultView(boolean point, String view) {
    this.point = point;
    this.view = view;
  }

  public static LadderResultView findByPoint(boolean targetPoint) {
    return Arrays.stream(values())
      .filter(data -> data.point == targetPoint)
      .findFirst()
      .get();
  }

  public String view() {
    return view;
  }
}
