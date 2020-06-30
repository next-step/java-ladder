package laddergame.model;

public class EmptyPoint implements Point {

  private final int position;

  public EmptyPoint(int position) {
    this.position = position;
  }

  @Override
  public int getPosition() {
    return position;
  }

  @Override
  public int getNextPosition() {
    return position;
  }

  @Override
  public boolean isEmpty() {
    return true;
  }
}
