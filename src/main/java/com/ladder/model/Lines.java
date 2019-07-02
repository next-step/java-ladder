package com.ladder.model;

import com.ladder.exception.LadderColumnsException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lines {

    public static final int MIN_NUMBER_OF_COLUMNS = 1;

    private List<Line> lines;

    private Lines(List<Line> lines) {
        this.lines = new ArrayList<>(lines);
    }

    static Lines of(List<Line> lines) {
        return new Lines(new ArrayList<>(lines));
    }

    static Lines of(int numberOfColumns, int numberOfPlayers) {
        if (numberOfColumns < MIN_NUMBER_OF_COLUMNS) {
            throw new LadderColumnsException();
        }
        List<Line> lines = IntStream.range(0, numberOfColumns)
                .mapToObj((num) -> Line.of(numberOfPlayers))
                .collect(Collectors.toList());
        return new Lines(lines);
    }

    Position playByOnePosition(Position startByPosition) {
        for (Line line : lines) {
            startByPosition = line.move(startByPosition);
        }
        return startByPosition;
    }

    List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
