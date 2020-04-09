package ladder.model.player;

import ladder.model.row.Row;

public interface FindPositionStrategy {
    int findNextPositionIncrement(Row row, Direction direction);
}
