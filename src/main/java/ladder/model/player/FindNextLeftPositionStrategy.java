package ladder.model.player;

import ladder.model.row.Row;

public class FindNextLeftPositionStrategy implements FindPositionStrategy {
    private static final int ZERO_LOCATION = 0;
    private static final int DECREASE_ONE = -1;
    private static final int INCREASE_ONE = +1;

    private int position;

    @Override
    public int findNextPositionIncrement(Row row, Direction direction) {
        return direction.getIncrement();
    }
}
