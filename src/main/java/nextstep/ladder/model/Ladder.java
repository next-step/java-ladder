package nextstep.ladder.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private List<Line> lines;
    private int height;

    public Ladder(int countOfPlayers, int height, LineGenerator lineGenerator) {
        this.height = height;
        this.lines = IntStream.range(0, height)
                .mapToObj(it -> new Line(countOfPlayers, lineGenerator))
                .collect(Collectors.toList());
    }

    public List<Line> getLines() {
        return lines;
    }

    public int getHeight() {
        return height;
    }
}
