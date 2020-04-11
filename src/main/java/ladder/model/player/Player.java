package ladder.model.player;

import ladder.model.row.Row;
import ladder.model.row.Rows;

public class Player {
    private static final int ZERO_LOCATION = 0;
    private static final int DECREASE_ONE = -1;

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
//
//    public Position findFinalLocation(Rows rows) {
//        for (Row row : rows.getRows()) {
//            position = findNextPosition(row);
//        }
//        return position;
//    }
//
//    public Position findNextPosition(Row nextRow) {
//        position = position.add(findNextDirection(nextRow).getIncrement());
//        return position;
//    }
//
//    private Direction findNextDirection(Row nextRow) {
//        return Direction.findDirection(isNextLeftPositionTrue(nextRow), isNextRightPositionTrue(nextRow));
//    }
//
//    private boolean isNextLeftPositionTrue(Row nextRow) {
//        return isFirstNow() ? false : nextRow.getRowElement(position.add(DECREASE_ONE));
//    }
//
//    private boolean isNextRightPositionTrue(Row nextRow) {
//        return isLastNow(nextRow) ? false : nextRow.getRowElement(position);
//    }
//
//    private boolean isFirstNow() {
//        return position.getPosition() == ZERO_LOCATION;
//    }
//
//    private boolean isLastNow(Row nextRow) {
//        return position.getPosition() == nextRow.getLastLocationValue();
//    }
}