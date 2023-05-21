package nextstep.ladder.domain;

import nextstep.ladder.util.RandomUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {

    private List<Line> lines = new ArrayList<>();

    private int height;

    public Ladder(int height) {
        this.height = height;
    }

    public void addLine(Line line) {
        lines.add(line);
    }

    public int getHeight() {
        return height;
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(this.lines);
    }

}
