package laddergame.domain;

import laddergame.exception.ErrorCode;
import laddergame.exception.LadderGameException;

import java.util.ArrayList;
import java.util.List;

public class Height {
    private final int height;

    public Height(int height) {
        if (height < 1) {
            throw new LadderGameException(ErrorCode.HEIGHT_UNDER_MINIMUM);
        }
        this.height = height;
    }

    public Ladder createLadder(Width width) {
        List<Row> rows = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            rows.add(width.createRow());
        }
        return new Ladder(rows);
    }
}
