package ladder.domain;

import java.util.*;
import java.util.stream.IntStream;

public class Coordinates {
  static Map<CacheKey, Coordinates> cache = new HashMap<>();

  private final int x;
  private final int y;

  static {
    IntStream.range(0, 10)
            .forEach(y -> {
              IntStream.range(0, 10)
                      .forEach(x -> cache.put(new CacheKey(x, y), Coordinates.of(x, y)));
            });
  }

  public static Coordinates of(final int x, final int y) {
    if (x < 0 || y < 0) {
      throw new IllegalStateException("음수 좌표를 가질 수 없습니다.");
    }

    CacheKey key = new CacheKey(x, y);
    cache.putIfAbsent(key, new Coordinates(x, y));
    return cache.get(key);
  }

  private Coordinates(final int x, final int y) {
    this.x = x;
    this.y = y;
  }

  public int x() {
    return this.x;
  }

  public int y() {
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
    return x == that.x && y == that.y;
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

  static class CacheKey {
    private final int x;
    private final int y;

    public CacheKey(final int x, final int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }

      CacheKey cacheKey = (CacheKey) o;
      return x == cacheKey.x && y == cacheKey.y;
    }

    @Override
    public int hashCode() {
      return Objects.hash(x, y);
    }
  }
}
