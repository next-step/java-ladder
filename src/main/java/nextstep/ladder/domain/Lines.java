package nextstep.ladder.domain;

import nextstep.ladder.domain.strategy.GenerateLadderPoint;
import nextstep.ladder.domain.strategy.RandomLadderPoint;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lines {
    private List<Line> lines;

    public Lines() {
    }

    public void initialize(int size, Height height, GenerateLadderPoint generateLadderPoint) {
        this.lines = createLines(size, height, generateLadderPoint);
    }

    public int move(int position) {
        for (Line line : lines) {
            position = line.move(position);
        }
        return position;
    }

    private List<Line> createLines(int size, Height height, GenerateLadderPoint generateLadderPoint) {
        return IntStream.range(0, height.getPoint())
                .mapToObj(i -> new Line(size, generateLadderPoint))
                .collect(Collectors.toList());
    }

    public List<Line> getLines() {
        return lines;
    }
}
