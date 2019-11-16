package ladder.domain;

import java.util.HashMap;
import java.util.Map;

public enum Moving {

    RIGHT(1),
    STAY(0),
    LEFT(-1);

    private final static Map<Move, Moving> FINDER;

    private int position;

    static {
        FINDER = new HashMap<>();
        FINDER.put(Move.right(), RIGHT);
        FINDER.put(Move.stay(), STAY);
        FINDER.put(Move.left(), LEFT);
    }

    Moving(int position) {
        this.position = position;
    }

    public static int getPosition(Move move) {
        return FINDER.get(move).position;
    }
}
