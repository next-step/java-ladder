package ladder.model.player;

import ladder.model.row.Row;
import ladder.model.row.Rows;

import static ladder.Messages.WARNING_NOT_ALLOWED_NAME_LENGTH;

public class Player {
    private static final int NAME_MAX_LENGTH = 5;
    private static final int ZERO_LOCATION = 0;
    private static final int DECREASE_ONE = -1;
    private static final int INCREASE_ONE = +1;

    private PlayerName name;
    private int location;

    public Player(String name) {
        this.name = new PlayerName(name);
    }

    public Player(String name, int location) {
        this.name = new PlayerName(name);
        this.location = location;
    }

    public String getName() {
        return name.getName();
    }

    public int findFinalLocation(Rows rows) {
        for (Row row : rows.getRows()) {
            location = findNextLocation(row);
        }
        return location;
    }

    public int findNextLocation(Row nextRow) {
        if (isNextLeftValueTrue(nextRow)) {
            return findNextLocationWhenLeft(nextRow);
        }
        if (isNextRightValueTrue(nextRow)) {
            return findNextLocationWhenRight(nextRow);
        }
        return location;
    }

    private int findNextLocationWhenRight(Row nextRow) {
        if (isNextRightValueTrue(nextRow)) {
            return location + INCREASE_ONE;
        }
        return location;
    }

    private int findNextLocationWhenLeft(Row nextRow) {
        if (isNextLeftValueTrue(nextRow)) {
            location = location + DECREASE_ONE;
        }
        return location;
    }

    private boolean isNextLeftValueTrue(Row nextRow) {
        if (isFirstNow()) {
            return false;
        }
        return nextRow.getRowElement(location + DECREASE_ONE);
    }

    private boolean isNextRightValueTrue(Row nextRow) {
        if (isLastNow(nextRow)) {
            return false;
        }
        return nextRow.getRowElement(location);
    }

    private boolean isFirstNow() {
        return location == ZERO_LOCATION;
    }

    private boolean isLastNow(Row nextRow) {
        return location == nextRow.getLastLocationValue();
    }
}