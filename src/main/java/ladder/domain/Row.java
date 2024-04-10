package ladder.domain;

import ladder.domain.movestrategy.NormalMoveStrategy;
import ladder.rowgenerator.RowGenerator;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Row implements Iterable<Point> {
  private final List<Boolean> values = new ArrayList<>();
  private final List<Point> points = new ArrayList<>();

  public static Row of(final int[] row, final Integer y) {
    return new Row(Arrays.stream(row)
            .mapToObj(Row::convertToBoolean)
            .collect(Collectors.toList()), y);
  }

  private static Boolean convertToBoolean(final int number) {
    if (number != 1 && number != 0) {
      throw new IllegalArgumentException("사다리 입력은 0, 1 값만 유효합니다.");
    }
    return number == 1;
  }

  public static Row of(final List<Boolean> row, final Integer y) {
    return new Row(row, y);
  }

  public static Row fromGenerator(RowGenerator generator, final Integer size, final Integer y) {
    final Row row = generator.generate(size, y);

    if (row.isNotSizeOf(size)) {
      throw new IllegalStateException("입력된 사다리 행(Row) 길이와 생성된 사다리 행 길이와 일치하지 않습니다.");
    }

    return row;
  }

  private Row(final List<Boolean> row, final Integer y) {
    validate(row);

    this.values.addAll(row);
    this.points.add(Point.first(y, row.get(0), new NormalMoveStrategy()));
    IntStream.range(1, row.size())
            .forEach(i -> {
              this.points.add(this.points.get(i - 1).next(row.get(i), new NormalMoveStrategy()));
            });
    this.points.add(this.points.get(this.points.size() - 1).last(new NormalMoveStrategy()));
  }

  private void validate(final List<Boolean> row) {
    IntStream.range(0, row.size() - 1)
            .forEach(i -> validateEach(row, i));
  }

  private void validateEach(final List<Boolean> row, final Integer index) {
    if (consecutiveTrue(row, index)) {
      throw new IllegalArgumentException("잘못된 사다리 입력입니다.");
    }
  }

  private boolean consecutiveTrue(final List<Boolean> row, int i) {
    return row.get(i) && row.get(i + 1);
  }

  public Integer size() {
    return this.values.size();
  }

  public List<Boolean> values() {
    return this.values;
  }

  public Coordinates nextPosition(final Coordinates position) {
    return this.points.get(position.x()).move();
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
    return this.points.equals(target.points);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.points);
  }

  @Override
  public Iterator<Point> iterator() {
    return new BooleanIterator();
  }

  private class BooleanIterator implements Iterator<Point> {
    private int cursor = 0;

    @Override
    public boolean hasNext() {
      return cursor < points.size();
    }

    @Override
    public Point next() {
      if (hasNext()) {
        return points.get(cursor++);
      }
      throw new IllegalStateException("더 이상 불러올 요소가 없습니다.");
    }
  }
}
