package ladder.domain;

public class LadderPart {

  private boolean leftConnect;
  private boolean rightConnect;

  public void connectRight() {
    this.rightConnect = true;
  }

  public void connectLeft() {
    this.leftConnect = true;
  }

  public boolean isLeftConnect() {
    return leftConnect;
  }

  public boolean isRightConnect() {
    return rightConnect;
  }
}
