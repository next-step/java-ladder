package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import nextstep.ladder.domain.line.Line;
import nextstep.ladder.domain.line.LinePoints;
import nextstep.ladder.domain.point.RandomPointGenerator;

public class Ladder {

    private static final int MIN_LINES = 1;
    private static final int MIN_PLAYER = 2;

    private List<Line> lines;
    private int sizeOfPerson;

    Ladder(List<Line> lines, int sizeOfPerson) {
        validate(lines, sizeOfPerson);
        this.lines = lines;
        this.sizeOfPerson = sizeOfPerson;
    }

    public static Ladder of(int height, int countOfPerson) {
        List<Line> lines = Stream.generate(() -> new Line(
            LinePoints.of(countOfPerson, new RandomPointGenerator())))
            .limit(height)
            .collect(Collectors.toList());

        return new Ladder(lines, countOfPerson);
    }

    private void validate(List<Line> lines, int sizeOfPerson) {
        if (lines.size() < MIN_LINES) {
            throw new IllegalArgumentException("min height is 1");
        }

        if (sizeOfPerson < MIN_PLAYER) {
            throw new IllegalArgumentException("min size Of Person is 2");
        }
    }

    public List<Line> getLines() {
        return new ArrayList<>(this.lines);
    }

    public LadderResult moveLines() {
        Map<Integer, Integer> results = new LinkedHashMap<>();
        for (int position = 0; position < sizeOfPerson; position++) {
            results.put(position, moveLines(position));
        }
        return new LadderResult(results);
    }

    private int moveLines(int position) {
        for (Line line : this.lines) {
            position = line.move(position);
        }
        return position;
    }
}
