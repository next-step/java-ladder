package net.chandol.ladder.v2.domain.line;

import java.util.Arrays;
import java.util.List;

public class ManualLinesGenerator implements LinesGenerator {
    private List<Line> linesValue;

    public ManualLinesGenerator(Line... linesValue) {
        this.linesValue = Arrays.asList(linesValue);
    }

    @Override
    public Lines generate(int size, int height) {
        return new Lines(linesValue);
    }
}
