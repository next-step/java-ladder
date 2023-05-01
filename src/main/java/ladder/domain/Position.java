package ladder.domain;

public class Position {

  private static final int MINIMUM_POSITION = 0;
  private final int position;

  public Position(int position) {
    validatePosition(position);

    this.position = position;
  }

  public int currentPosition() {
    return position;
  }

  public Position moveNext() {
    return new Position(position + 1);
  }

  public Position movePrevious() {
    return new Position(position - 1);
  }

  private void validatePosition(int position) {
    if (position < MINIMUM_POSITION) {
      throw new IllegalArgumentException("유저의 위치가 음수일 수는 없습니다.");
    }
  }
}
