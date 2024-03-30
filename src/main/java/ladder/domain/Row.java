package ladder.domain;

import ladder.rowgenerator.RowGenerator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Row implements Iterable<Boolean> {
  private List<Boolean> row;

  public static Row of(final int[] row) {
    return new Row(Arrays.stream(row)
            .mapToObj(i -> i != 0)
            .collect(Collectors.toList()));
  }

  public static Row of(final List<Boolean> row) {
    return new Row(row);
  }

  public static Row fromGenerator(RowGenerator generator) {
    return generator.generate();
  }

  private Row(final List<Boolean> row) {
    if (validate(row)) {
      this.row = row;
      return;
    }
    throw new IllegalArgumentException("잘못된 사다리 입력입니다.");
  }

  private boolean validate(final List<Boolean> row) {
    return IntStream.range(0, row.size() - 1)
            .allMatch(i -> notConsecutiveTrue(row, i));
  }

  private boolean notConsecutiveTrue(final List<Boolean> row, int i) {
    return !(row.get(i) && row.get(i + 1));
  }

  public Integer size() {
    return this.row.size();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Row booleans = (Row) o;
    return row.equals(booleans.row);
  }

  @Override
  public int hashCode() {
    return Objects.hash(row);
  }

  @Override
  public Iterator<Boolean> iterator() {
    return new BooleanIterator();
  }

  private class BooleanIterator implements Iterator<Boolean> {
    private int cursor = 0;

    @Override
    public boolean hasNext() {
      return cursor < row.size();
    }

    @Override
    public Boolean next() {
      return row.get(cursor++);
    }
  }
}
