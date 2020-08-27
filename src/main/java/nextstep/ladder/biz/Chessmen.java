package nextstep.ladder.biz;

import java.util.Objects;

public class Chessmen {

  private int location;

  public Chessmen(int location) {
    if (0 > location) {
      throw new IllegalArgumentException("말의 위치가 잘 못되었습니다. ");
    }

    this.location = location;
  }

  public static Chessmen location(int value) {
    return new Chessmen(value);
  }

  public void down(Point point) {
    location = point.decide(location);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Chessmen chessmen = (Chessmen) o;
    return location == chessmen.location;
  }

  @Override
  public int hashCode() {
    return Objects.hash(location);
  }

  @Override
  public String toString() {
    return "Chessmen{" +
        "location=" + location +
        '}';
  }
}
