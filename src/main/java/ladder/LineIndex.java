package ladder;

import java.util.Objects;

public class LineIndex {

  private static final String MESSAGE_FOR_INVALID_NAME = "해당 이름과 일치하는 참가자가 존재하지 않습니다.";
  private static final String MESSAGE_FOR_INVALID_INDEX = "현재 위치는 0과 참가자수 사이여야 합니다.";
  private static final int NEXT = 1;
  private static final int PREV = 1;

  private final int playerNumber;
  private final int index;

  LineIndex(int playerNumber, int index) {
    validateIndex(playerNumber, index);
    this.playerNumber = playerNumber;
    this.index = index;
  }

  public LineIndex moveRight() {
    return new LineIndex(playerNumber, index + NEXT);
  }

  public LineIndex moveLeft() {
    return new LineIndex(playerNumber, index - PREV);
  }

  public int value() {
    return index;
  }

  private void validateIndex(int playerNumber, int index) {
    if (index < 0 || playerNumber <= index) {
      throw new IllegalArgumentException(MESSAGE_FOR_INVALID_INDEX);
    }
  }

  public static LineIndex init(Players players, Name name) {
    if (!players.has(name)) {
      throw new IllegalArgumentException(MESSAGE_FOR_INVALID_NAME);
    }
    return new LineIndex(players.playerNumber(), players.startIndexOf(name));
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LineIndex lineIndex = (LineIndex) o;
    return playerNumber == lineIndex.playerNumber && index == lineIndex.index;
  }

  @Override
  public int hashCode() {
    return Objects.hash(playerNumber, index);
  }
}
