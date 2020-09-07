package nextstep.ladder.biz;

import nextstep.ladder.Player;

import java.util.Objects;

public class Chessmen {

  private final Player player;
  private final int location;

  private Chessmen(Player player) {
    this(player, player.getLocation());
  }

  private Chessmen(Player player, int location) {
    if (isOnLadder(location)) {
      throw new IllegalArgumentException("말의 위치가 잘 못되었습니다. ");
    }
    this.player = player;
    this.location = location;
  }

  public String getName() {
    return player.getName();
  }

  private boolean isOnLadder(int location) {
    return 0 > location;
  }

  public int getLocation() {
    return location;
  }

  public Chessmen cast(Line line) {
    return line.castingLine(this).getPoints().stream()
            .filter(Point::hasPoint)
            .findFirst()
            .map(this::move)
            .orElse(this);
  }

  private Chessmen move(Point point) {
    if (isHere(point)) {
      return moveRight();
    } else if (isLeft(point)) {
      return moveLeft();
    }

    return this;
  }

  private boolean isLeft(Point point) {
    if (isZeroIndex()) {
      return false;
    }
    return point.isLeftPosition(this.location);
  }

  private boolean isZeroIndex() {
    return location == 0;
  }

  private boolean isHere(Point point) {
    return point.isHerePosition(this.location);
  }

  Chessmen moveLeft() {
    return Chessmen.of(player, location -1);
  }

  Chessmen moveRight() {
    return Chessmen.of(player, location + 1);
  }

  Chessmen move(int location) {
    return Chessmen.of(player, location);
  }

  public static Chessmen of(Player player) {
    return new Chessmen(player);
  }

  static Chessmen of(Player player, int location) {
    return new Chessmen(player, location);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Chessmen chessmen = (Chessmen) o;
    return location == chessmen.location &&
            Objects.equals(player, chessmen.player);
  }

  @Override
  public int hashCode() {
    return Objects.hash(player, location);
  }

  @Override
  public String toString() {
    return player.getName() + "[" + player.getLocation() + "] - current location:" + location;
  }
}
