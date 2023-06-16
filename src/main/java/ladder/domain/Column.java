package ladder.domain;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import ladder.exception.OutOfColumnRangeException;

public class Column {

  private static final Map<Integer, Column> COLUMNS_CACHE =
      IntStream.rangeClosed(0, 50)
          .boxed()
          .collect(Collectors.toMap(i -> i, Column::new));

  private final int value;

  private Column(int value) {
    this.value = value;
  }

  public static Column of(int value) {
    if (value < 0) {
      throw new OutOfColumnRangeException();
    }
    return COLUMNS_CACHE.computeIfAbsent(value, Column::new);
  }

  public boolean isAdjacent(Column other) {
    return Math.abs(this.value - other.value) <= 1;
  }

  public boolean isSame(Column other) {
    return equals(other);
  }

  public int getValue() {
    return this.value;
  }

  public boolean isGraterThan(Column other) {
    return this.value - 1 > other.value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Column otherColumn = (Column) o;
    return this.hashCode() == otherColumn.hashCode();
  }

  @Override
  public int hashCode() {
    return value;
  }
}
