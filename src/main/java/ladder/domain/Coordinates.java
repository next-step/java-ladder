package ladder.domain;

import java.util.Objects;
import java.util.stream.IntStream;

public class Coordinates {
  static Coordinates[][] cache = new Coordinates[10][10];

  private final Integer x;
  private final Integer y;

  static {
    IntStream.range(0, 10)
            .forEach(y -> IntStream.range(0, 10)
                    .forEach(x -> cache[y][x] = Coordinates.of(x, y))
            );
  }

  public static Coordinates of(final Integer x, final Integer y) {
    if (x < 0 || y < 0) {
      throw new IllegalStateException("음수 좌표를 가질 수 없습니다.");
    }

    if (cache[y][x] != null) {
      return cache[y][x];
    }

    return new Coordinates(x, y);
  }

  private Coordinates(final Integer x, final Integer y) {
    this.x = x;
    this.y = y;
    cache[y][x] = this;
  }

  public Integer x() {
    return this.x;
  }

  public Integer y() {
    return this.y;
  }

  public Coordinates downRight() {
    return Coordinates.of(this.x + 1, this.y + 1);
  }

  public Coordinates downLeft() {
    return Coordinates.of(this.x - 1, this.y + 1);
  }

  public Coordinates downStraight() {
    return Coordinates.of(this.x, this.y + 1);
  }

  public Coordinates right() {
    return Coordinates.of(this.x + 1, this.y);
  }

  public Coordinates left() {
    return Coordinates.of(this.x - 1, this.y);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Coordinates that = (Coordinates) o;
    return x.equals(that.x) && y.equals(that.y);
  }

  @Override
  public int hashCode() {
    return Objects.hash(x, y);
  }

  @Override
  public String toString() {
    return "Coordinates{" +
            "x=" + x +
            ", y=" + y +
            '}';
  }
}
