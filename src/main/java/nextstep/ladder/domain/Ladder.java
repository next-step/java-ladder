package nextstep.ladder.domain;

import nextstep.ladder.util.RandomUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {

    private List<Line> lines;

    public Ladder(int height, int width) {
        addLine(height, width);
    }

    private void addLine(int height, int width) {
        List<Line> lines = new ArrayList<>();
        IntStream.range(0, height)
                .mapToObj(i -> new Line(width))
                .forEach(lines::add);
        this.lines = lines;
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(this.lines);
    }

}
