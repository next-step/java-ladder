package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderPartLine {

  private final List<LadderPart> line;

  private LadderPartLine(List<LadderPart> line) {
    this.line = line;
  }

  public static LadderPartLine of(List<Boolean> connects) {
    List<LadderPart> partLine = new ArrayList<>();
    for (int widthPoint = 0; widthPoint < connects.size(); widthPoint++) {
      boolean left = isConnectLeft(widthPoint, connects);
      boolean right = isConnectRight(widthPoint, connects);
      partLine.add(new LadderPart(left, right));
    }
    return new LadderPartLine(partLine);
  }

  private static boolean isConnectRight(int widthPoint, List<Boolean> connects) {
    return connects.get(widthPoint);
  }

  private static boolean isConnectLeft(int widthPoint, List<Boolean> connects) {
    int previousPoint = widthPoint - 1;
    if (previousPoint < 0) {
      return false;
    }
    return connects.get(previousPoint);
  }

  public boolean isRightConnect(int widthPoint) {
    return line.get(widthPoint).isRightConnect();
  }

  public boolean isLeftConnect(int widthPoint) {
    return line.get(widthPoint).isLeftConnect();
  }

  public int getLadderWidth() {
    return line.size();
  }
}
