package ladder.domain.Line;

public class LinePoint {

  private boolean isRightConnected;

  public LinePoint (boolean isRightConnected) {
    this.isRightConnected = isRightConnected;
  }

  public boolean isRightConnected() {
    return isRightConnected;
  }

  @Override
  public String toString() {
    return isRightConnected
        ? String.format("%6s", "|-----")
        : String.format("%6s", "|") ;
  }
}
