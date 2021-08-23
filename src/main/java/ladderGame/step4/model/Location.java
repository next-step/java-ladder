package ladderGame.step4.model;

import java.util.Objects;

public class Location {

  public static final String MSG_ERROR_INVALID_VALUE = "잘못된 사다리 생성입니다.";

  private final boolean left;

  private final boolean right;

  private Location(final boolean left, final boolean right) {
    validationValues(left, right);
    this.left = left;
    this.right = right;
  }

  private void validationValues(final boolean before, final boolean current) {
    if (before && current) {
      throw new IllegalArgumentException(MSG_ERROR_INVALID_VALUE);
    }
  }

  public static Location first(final boolean right) {
    return new Location(false, right);
  }

  public Location nextLocation(final boolean right) {
    return new Location(this.right, right);
  }

  public Direction movement() {

    if (right) {
      return Direction.FORWARD;
    }

    if (left) {
      return Direction.BACK;
    }

    return Direction.HOLD;
  }

  public int point(Direction direction) {
    return direction.getMovingPoint();
  }

  public Location next(final boolean right) {
    if (this.right) {
      return Location.first(true).nextLocation(false);
    }

    return Location.first(false).nextLocation(right);
  }

  public Location last() {
    return new Location(this.right, false);
  }

  public boolean locationValue() {
    return left;
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
    return left == location.left && right == location.right;
  }

  @Override
  public int hashCode() {
    return Objects.hash(left, right);
  }
}