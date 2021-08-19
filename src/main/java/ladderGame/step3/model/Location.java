package ladderGame.step3.model;

import java.util.Objects;
import ladderGame.step3.util.RandomMove;

public class Location {

  public static final String MSG_ERROR_INVALID_VALUE = "잘못된 사다리 생성입니다.";

  private final boolean before;

  private final boolean current;

  public Location(final boolean before, final boolean current) {
    validationValues(before, current);
    this.before = before;
    this.current = current;
  }

  private void validationValues(final boolean before, final boolean current) {
    if (before && current) {
      throw new IllegalArgumentException(MSG_ERROR_INVALID_VALUE);
    }
  }

  public static Location first(final boolean current) {
    return new Location(false, current);
  }

  public Location nextLocation(final boolean current) {
    return new Location(this.current, current);
  }

  public Direction movement() {

    if (current) {
      return Direction.FORWARD;
    }

    if (before) {
      return Direction.BACK;
    }

    return Direction.HOLD;
  }

  public int point(Direction direction) {
    return direction.getMovingPoint();
  }

  public Location next(final Location beforeLocation) {
    if (beforeLocation.current) {
      return Location.first(true).nextLocation(false);
    }

    return Location.first(false).nextLocation(RandomMove.createRandomMoveValue());
  }

  public Location last() {
    return new Location(this.current, false);
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    final Location location = (Location) o;
    return before == location.before && current == location.current;
  }

  @Override
  public int hashCode() {
    return Objects.hash(before, current);
  }
}