package ladder.rowgenerator;

import ladder.domain.Row;

@FunctionalInterface
public interface RowGenerator {
  Row generate(final int size, final int y);
}
