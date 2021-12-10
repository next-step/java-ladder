package nextstep.ladder.domain;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Lines {
    private final List<Line> lines;

    public Lines(List<Line> lines) {
        this.lines = lines;
    }

    public static Lines ofRandom(int countOfParticipants, int countOfLine) {
        List<Line> lines = new ArrayList<>();
        IntStream.range(0, countOfLine)
                .forEach(index -> lines.add(Line.ofRandom(countOfParticipants)));
        return new Lines(lines);
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
