package nextstep.mission.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lines {

    private final List<Line> lines;

    public Lines(int size, int height) {
        this.lines = Stream.generate(() -> Line.init(size))
                .limit(height)
                .collect(Collectors.toList());
    }

    public Lines(List<Line> lines) {
        this.lines = lines;
    }

    private Line getLine(int position) {
        return getLines().get(position);
    }

    private Line getFirstLine() {
        return getLine(0);
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

    public int getResultByPosition(int startPosition) {
        int position = getFirstLine().move(startPosition);

        for (int index = 1; index < lines.size(); index++) {
            position = getLine(index).move(position);
        }

        return position;
    }
}
