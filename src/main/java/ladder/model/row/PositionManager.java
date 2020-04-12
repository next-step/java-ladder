package ladder.model.row;

public class PositionManager {
    private static final int ZERO_LOCATION = 0;
    private static final int DECREASE_ONE = -1;

    private Position initialPosition;
    private Position finalPosition;

    public PositionManager(Position initialPosition) {
        this.initialPosition = initialPosition;
    }

    public static PositionManager of(Position position) {
        return new PositionManager(position);
    }

    public void move(Rows rows) {
        finalPosition = findFinalLocation(rows);
    }

    public Position getFinalPosition() {
        return finalPosition;
    }

    private Position findFinalLocation(Rows rows) {
        for (Row row : rows.getRows()) {
            initialPosition = Position.of(findNextPosition(row).getPosition());
        }
        return initialPosition;
    }

    private Position findNextPosition(Row nextRow) {
        initialPosition = Position.of(initialPosition.getPosition() + findNextDirection(nextRow).getIncrement());
        return initialPosition;
    }

    private Direction findNextDirection(Row nextRow) {
        return Direction.findDirection(isNextLeftPositionTrue(nextRow), isNextRightPositionTrue(nextRow));
    }

    private boolean isNextLeftPositionTrue(Row nextRow) {
        return isFirstNow() ? false : nextRow.getRowElement(Position.of(initialPosition.add(DECREASE_ONE)));
    }

    private boolean isNextRightPositionTrue(Row nextRow) {
        return isLastNow(nextRow) ? false : nextRow.getRowElement(initialPosition);
    }

    private boolean isFirstNow() {
        return initialPosition.getPosition() == ZERO_LOCATION;
    }

    private boolean isLastNow(Row nextRow) {
        return initialPosition.getPosition() == nextRow.getLastLocationValue();
    }
}