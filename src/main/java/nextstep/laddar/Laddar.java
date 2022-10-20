package nextstep.laddar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Laddar {

    List<Line> lines = new ArrayList<>();

    public Laddar(int height, int count, BooleanGenerator booleanGenerator) {
        IntStream.range(0, height)
                .forEach((i) -> lines.add(new Line(count)));

        lines.forEach(line -> line.makeHorizontalLines(booleanGenerator));
    }

    public List<Line> getLines() {
        return lines;
    }
}
