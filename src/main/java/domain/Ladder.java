package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private List<Line> lines = new ArrayList<>();

    public Ladder(Integer length, Integer height) {
        IntStream.range(0, height)
            .mapToObj(i -> new Line(length, new RandomNumberLottery()))
            .forEach(lines::add);
    }

    public List<Line> getLines() {
        return lines;
    }

    @Override
    public String toString() {
        return lines.stream()
            .map(Line::toString)
            .collect(Collectors.joining("\n"));
    }
}
