package ladder.domain;

import ladder.rowgenerator.RowGenerator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Row implements Iterable<Boolean> {
  private final List<Boolean> values;

  public static Row of(final int[] row) {
    return new Row(Arrays.stream(row)
            .mapToObj(Row::convertToBoolean)
            .collect(Collectors.toList()));
  }

  private static Boolean convertToBoolean(final int number) {
    if (number != 1 && number != 0) {
      throw new IllegalArgumentException("사다리 입력은 0, 1 값만 유효합니다.");
    }
    return number == 1;
  }

  public static Row of(final List<Boolean> row) {
    return new Row(row);
  }

  public static Row fromGenerator(RowGenerator generator, final Integer size) {
    final Row row = generator.generate(size);

    if (row.isNotSizeOf(size)) {
      throw new IllegalStateException("입력된 사다리 행(Row) 길이와 생성된 사다리 행 길이와 일치하지 않습니다.");
    }

    return row;
  }

  private Row(final List<Boolean> rows) {
    if (validate(rows)) {
      this.values = rows;
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
    return this.values.size();
  }

  public List<Boolean> values() {
    return this.values;
  }

  public int nextPosition(final int position) {
    if (isValid(position) && this.values.get(position)) {
      return position + 1;
    }

    if (isValid(position - 1) && this.values.get(position - 1)) {
      return position - 1;
    }

    return position;
  }

  private boolean isValid(final int index) {
    return 0 <= index && index < this.values.size();
  }

  public boolean isNotSizeOf(final int size) {
    return this.values.size() != size;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Row target = (Row) o;
    return this.values.equals(target.values);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.values);
  }

  @Override
  public Iterator<Boolean> iterator() {
    return new BooleanIterator();
  }

  private class BooleanIterator implements Iterator<Boolean> {
    private int cursor = 0;

    @Override
    public boolean hasNext() {
      return cursor < values.size();
    }

    @Override
    public Boolean next() {
      if (hasNext()) {
        return values.get(cursor++);
      }
      throw new IllegalStateException("더 이상 불러올 요소가 없습니다.");
    }
  }
}
