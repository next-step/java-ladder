package ladder.domain.coordinate;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import ladder.exception.OutOfRowRangeException;

public class Row extends Coordinate{

  public Row(int value) {
    super(value);
  }

  private static final Map<Integer, Row> ROW_CACHE =
      IntStream.rangeClosed(0, 50)
          .boxed()
          .collect(Collectors.toMap(i -> i,Row::new ));

  public static Row of(int value) {
    if (value < 0) {
      throw new OutOfRowRangeException();
    }
    return ROW_CACHE.computeIfAbsent(value, Row::new);
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
