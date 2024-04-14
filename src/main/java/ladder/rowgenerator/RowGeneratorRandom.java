package ladder.rowgenerator;

import ladder.domain.Row;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class RowGeneratorRandom implements RowGenerator {
  private final Random random = ThreadLocalRandom.current();

  public RowGeneratorRandom() {
  }

  @Override
  public Row generate(final int size, final int y) {
    List<Boolean> row = new ArrayList<>(size);

    IntStream.range(0, size)
            .forEach(i -> row.add(rowValue(row, i)));

    return Row.of(row, y);
  }

  private Boolean rowValue(final List<Boolean> row, final int index) {
    if (index == 0 || !row.get(index - 1)) {
      return randomValue();
    }
    return false;
  }

  private boolean randomValue() {
    return this.random.nextBoolean();
  }
}
