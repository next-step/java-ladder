package ladder.model.player;

import ladder.model.row.Row;
import ladder.model.row.Rows;

public class Player {
    private static final int ZERO_LOCATION = 0;
    private static final int DECREASE_ONE = -1;
    private static final int INCREASE_ONE = +1;

    private PlayerName name;
    private Position position;

    public Player(String name) {
        this.name = new PlayerName(name);
    }

    public Player(String name, int position) {
        this.name = new PlayerName(name);
        this.position = new Position(position);
    }

    public PlayerName getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    public int getIndex() {
        return position.getPosition();
    }

    public boolean hasEqualName(String name) {
        return name.equals(this.name.getName());
    }

    public Position findFinalLocation(Rows rows) {
        for (Row row : rows.getRows()) {
            position = findNextLocation(row);
        }
        return position;
    }

    public Position findNextLocation(Row nextRow) {
        if (isNextLeftValueTrue(nextRow)) {
            return findNextLocationWhenLeft(nextRow);
        }
        if (isNextRightValueTrue(nextRow)) {
            return findNextLocationWhenRight(nextRow);
        }
        return position;
    }

    private Position findNextLocationWhenRight(Row nextRow) {
        if (isNextRightValueTrue(nextRow)) {
            return new Position(position.getPosition() + INCREASE_ONE);
        }
        return position;
    }

    private Position findNextLocationWhenLeft(Row nextRow) {
        if (isNextLeftValueTrue(nextRow)) {
            position = new Position(position.getPosition() + DECREASE_ONE);
        }
        return position;
    }

    private boolean isNextLeftValueTrue(Row nextRow) {
        if (isFirstNow()) {
            return false;
        }
        return nextRow.getRowElement(position.add(DECREASE_ONE));
    }

    private boolean isNextRightValueTrue(Row nextRow) {
        if (isLastNow(nextRow)) {
            return false;
        }
        return nextRow.getRowElement(position);
    }

    private boolean isFirstNow() {
        return position.getPosition() == ZERO_LOCATION;
    }

    private boolean isLastNow(Row nextRow) {
        return position.getPosition() == nextRow.getLastLocationValue();
    }
}