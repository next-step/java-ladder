package ladder.domain;

public class LadderPart {

  private final boolean leftConnect;
  private final boolean rightConnect;

  public LadderPart(boolean leftConnect, boolean rightConnect) {
    this.leftConnect = leftConnect;
    this.rightConnect = rightConnect;
  }

  public boolean isLeftConnect() {
    return leftConnect;
  }

  public boolean isRightConnect() {
    return rightConnect;
  }
}
