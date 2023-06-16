package ladder.domain.coordinate;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import ladder.exception.OutOfColumnRangeException;

public class Column extends Coordinate {

  private static final Map<Integer, Column> COLUMNS_CACHE =
      IntStream.rangeClosed(0, 50)
          .boxed()
          .collect(Collectors.toMap(i -> i, Column::new));

  private Column(int value) {
    super(value);
  }

  public static Column of(int value) {
    if (value < 0) {
      throw new OutOfColumnRangeException();
    }
    return COLUMNS_CACHE.computeIfAbsent(value, Column::new);
  }
}
