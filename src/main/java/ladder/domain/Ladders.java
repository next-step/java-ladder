package ladder.domain;

import ladder.rowgenerator.RowGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladders implements Iterable<Row> {
  private final List<Row> ladders;

  public static Ladders rows(final int[][] ladders) {
    return new Ladders(Arrays.stream(ladders)
            .map(Row::of)
            .collect(Collectors.toList()));
  }

  public static Ladders rows(final List<Row> ladders) {
    return new Ladders(ladders);
  }

  public static Ladders of(final int height, final RowGenerator generator) {
    final List<Row> ladders = new ArrayList<>(height);

    IntStream.range(0, height)
            .forEach(i -> ladders.add(Row.fromGenerator(generator)));

    return new Ladders(ladders);
  }

  private Ladders(final List<Row> ladders) {
    if (ladders.size() == 0) {
      throw new IllegalArgumentException("잘못된 사다리 입력입니다.");
    }
    this.ladders = ladders;
  }

  @Override
  public Iterator<Row> iterator() {
    return new RowIterator();
  }

  private class RowIterator implements Iterator<Row> {
    private int cursor = 0;

    @Override
    public boolean hasNext() {
      return cursor < ladders.size();
    }

    @Override
    public Row next() {
      return ladders.get(cursor++);
    }
  }
}
