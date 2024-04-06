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
  public Row generate(final Integer size) {
    List<Boolean> row = new ArrayList<>(size);

    IntStream.range(0, size)
            .forEach(i -> row.add(rowValue(row, i)));

    return Row.of(row);
  }

  private Boolean rowValue(final List<Boolean> row, final int index) {
    if (index == 0 || !row.get(index - 1)) {
      return randomValue();
    }
    return false;
  }

  private List<Boolean> rowReducer(final List<Boolean> acc, final int cur) {
    acc.add((cur != 0));
    return acc;
  }

  private List<Boolean> rowCombiner(final List<Boolean> list1, final List<Boolean> list2) {
    list1.addAll(list2);
    return list1;
  }

  private boolean randomValue() {
    return this.random.nextBoolean();
  }
}
