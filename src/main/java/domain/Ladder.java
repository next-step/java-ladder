package domain;

public class Ladder {

  private int height;

  public Ladder(int height) {

    if (height <= 0) {
      throw new IllegalArgumentException();
    }
    this.height = height;
  }

  public int getHeight() {
    return height;
  }
}
