package nextstep.ladder.domain;

import nextstep.ladder.strategy.RandomStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Lines {
    private List<Line> lines;

    public Lines(List<Line> lines) {
        this.lines = lines;
    }

    public List<Line> getLines() {
        return lines;
    }

    public static Lines of(int countOfParticipants, int countOfLine) {
        List<Line> lines = new ArrayList<>();
        IntStream.range(0, countOfLine)
                .forEach(index -> {
                    Line line = Line.of(countOfParticipants, new RandomStrategy());
                    lines.add(line);
                });
        return new Lines(lines);
    }
}
