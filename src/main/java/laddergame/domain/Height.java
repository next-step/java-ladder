package laddergame.domain;

import laddergame.exception.ErrorCode;
import laddergame.exception.LadderGameException;

import java.util.ArrayList;
import java.util.List;

public class Height {
    public static final int MINIMUM_OF_HEIGHT = 1;
    private final int height;

    public Height(int height) {
        validateOverMinimum(height);
        this.height = height;
    }

    private void validateOverMinimum(int height) {
        if (height < MINIMUM_OF_HEIGHT) {
            throw new LadderGameException(ErrorCode.HEIGHT_UNDER_MINIMUM);
        }
    }

    public Ladder createLadder(Width width) {
        List<Row> rows = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            rows.add(width.createRow());
        }
        return new Ladder(rows);
    }
}
