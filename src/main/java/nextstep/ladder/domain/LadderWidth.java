package nextstep.ladder.domain;

import java.util.HashMap;

public class LadderWidth {
    private static final int START_INDEX = 0;
    private final int width;

    public LadderWidth(int width) {
        this.width = width;
    }

    public Position position() {
        HashMap<Integer, Integer> result = new HashMap<>();
        for (int i = START_INDEX; i < width; i++) {
            result.put(i, i);
        }
        return new Position(result);
    }
}
