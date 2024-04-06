package ladder.domain;

import ladder.rowgenerator.RowGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder implements Iterable<Row> {
  private final List<Row> rows;

  public static Ladder from(final int[][] ladder) {
    return new Ladder(Arrays.stream(ladder)
            .map(Row::of)
            .collect(Collectors.toList()));
  }

  public static Ladder from(final List<Row> rows) {
    return new Ladder(rows);
  }

  public static Ladder of(final Integer height, final Integer width, final RowGenerator generator) {
    final List<Row> ladder = new ArrayList<>(height);

    IntStream.range(0, height)
            .forEach(i -> ladder.add(Row.fromGenerator(generator, width)));

    return new Ladder(ladder);
  }

  private Ladder(final List<Row> rows) {
    if (rows.isEmpty()) {
      throw new IllegalArgumentException("잘못된 사다리 입력입니다.");
    }

    Integer width = rows.get(0).size();
    for (Row row : rows) {
      if (row.isNotSizeOf(width)) {
        throw new IllegalArgumentException("길이가 다른 행(Row) 입력이 있습니다.");
      }
    }

    this.rows = rows;
  }

  public List<Row> rows() {
    return this.rows;
  }

  public int finalPosition(final int startPosition) {
    int position = startPosition;

    for (Row row : this.rows) {
      position = row.nextPosition(position);
    }

    return position;
  }

  @Override
  public Iterator<Row> iterator() {
    return new RowIterator();
  }

  private class RowIterator implements Iterator<Row> {
    private int cursor = 0;

    @Override
    public boolean hasNext() {
      return cursor < rows.size();
    }

    @Override
    public Row next() {
      if (hasNext()) {
        return rows.get(cursor++);
      }
      throw new IllegalStateException("더 이상 불러올 요소가 없습니다.");
    }
  }
}
