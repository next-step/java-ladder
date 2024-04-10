package ladder.rowgenerator;

import ladder.domain.Row;

@FunctionalInterface
public interface RowGenerator {
  Row generate(final Integer size, final Integer y);
}
