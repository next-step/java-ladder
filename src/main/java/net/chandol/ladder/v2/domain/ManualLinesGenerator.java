package net.chandol.ladder.v2.domain;

import java.util.Arrays;
import java.util.List;

public class ManualLinesGenerator implements LinesGenerator {
    private List<Line> lines;

    public ManualLinesGenerator(Line... lines) {
        this.lines = Arrays.asList(lines);
    }

    @Override
    public List<Line> generate(int size, int height) {
        return lines;
    }
}
