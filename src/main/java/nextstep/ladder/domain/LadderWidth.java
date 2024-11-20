package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderWidth {
    private static final int START_INDEX = 0;
    private final int width;

    public LadderWidth(int width) {
        this.width = width;
    }

    public Position position() {
        List<Integer> result = new ArrayList<>();
        for (int i = START_INDEX; i < width; i++) {
            result.add(i);
        }
        return new Position(result);
    }
}
