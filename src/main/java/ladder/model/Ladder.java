package ladder.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static ladder.model.Line.createOneLine;

public class Ladder {
    private List<Line> lines = new ArrayList<>();

    public Ladder(int heightOfLadder, int NumberOfName) {
        checkIndex(heightOfLadder, NumberOfName);

        for (int i = 0; i < heightOfLadder; i++) {
            this.lines.add(createOneLine(NumberOfName));
        }
    }

    private void checkIndex(int heightOfLadder, int NumberOfName) {
        if (heightOfLadder <= 0) {
            throw new IllegalArgumentException("사다리 높이는 1이상.");
        }
        if (NumberOfName <= 0) {
            throw new IllegalArgumentException("사람수는 1이상.");
        }
    }

    public List<Line> getLines() {
        return lines;
    }
}
