package ladder.domain;

import java.util.Collections;
import java.util.List;

public class Stairs {
    private final List<Stair> stairs;

    public Stairs(final List<Stair> stair) {
        this.stairs = Collections.unmodifiableList(stair);
    }

    public int count() {
        return stairs.size();
    }

    public List<Stair> getStairs() {
        return stairs;
    }

    public Position move(final Position position) {
        int playerPosition = position.value();
        // 좌측 이동이 가능한지
        if (isMovableLeft(playerPosition)) {
            return position.left();
        }

        // 우측 이동이 가능한지
        if (isMovableRight(playerPosition)) {
            return position.right();
        }
        return position;
    }

    private boolean isMovableLeft(final int playerPosition) {
        return stairs.get(playerPosition).isExist();
    }

    private boolean isMovableRight(final int playerPosition) {
        return isLineIn(playerPosition) && nextStair(playerPosition).isExist();
    }

    private boolean isLineIn(final int playerPosition) {
        return playerPosition + Position.NEXT < stairs.size();
    }

    private Stair nextStair(final int playerPosition) {
        return stairs.get(playerPosition + Position.NEXT);
    }
}
