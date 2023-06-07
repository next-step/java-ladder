package nextstep.laddergame.engine;

public class Point {

  private boolean left;
  private boolean right;

  public Point() {
    this(false, false);
  }

  private Point(boolean left, boolean right) {
    this.left = left;
    this.right = right;
  }

  public boolean checkLeftWay() {
    return left;
  }

  public boolean checkRightWay() {
    return right;
  }

  public boolean checkTwoWay() {
    return left && right;
  }

  public void createLineWithLeftPoint() {
    left = true;
  }

  public void createLineWithRightPoint() {
    right = true;
  }
}
