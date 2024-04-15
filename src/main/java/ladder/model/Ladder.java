package ladder.model;

import ladder.model.utils.ConnectLine;

import java.util.ArrayList;
import java.util.List;

import static ladder.model.Line.createOneLine;

public class Ladder {
    private List<Line> lines = new ArrayList<>();

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public Ladder(int heightOfLadder, int numberOfName, ConnectLine connectLine) {
        checkIndex(heightOfLadder, numberOfName);

        for (int i = 0; i < heightOfLadder; i++) {
            this.lines.add(createOneLine(numberOfName, connectLine));
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
