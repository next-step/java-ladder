package ladder.domain;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import ladder.exception.OutOfRowRangeException;

public class Row {

  private static final int ROW_CACHE_MAX = 50;

  private static final Map<Integer, Row> ROW_CACHE =
      IntStream.rangeClosed(0, ROW_CACHE_MAX)
          .boxed()
          .collect(Collectors.toMap(i -> i, Row::new));
  private final int value;

  private Row(int value) {
    this.value = value;
  }

  public static Row of(int value) {
    if (value < 0) {
      throw new OutOfRowRangeException();
    }
    return ROW_CACHE.computeIfAbsent(value, Row::new);
  }

  public boolean isSame(Row otherRow) {
    return this.value == otherRow.value;
  }

  public int getValue() {
    return value;
  }

  public boolean isGraterThan(Row other) {
    return this.value < other.value;
  }

  @Override
  public int hashCode() {
    return this.value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Row otherRow = (Row) o;
    return this.hashCode() == otherRow.hashCode();
  }
}
