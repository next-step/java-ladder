package nextstep.mission.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lines {

    private List<Line> lines;

    public Lines(int size, int height) {
        this.lines = Stream.generate(() -> new Line(size))
                .limit(height)
                .collect(Collectors.toList());
    }

    public Lines(List<Line> lines) {
        this.lines = lines;
    }

    public boolean checkHeight(int height) {
        return this.lines.size() == height;
    }

    private Line getLine(int position) {
        return this.lines.get(position);
    }

    public List<Line> getLines() {
        return lines;
    }

    public int getResultPosition(int startPosition) {
        int position = getLine(0).nextPosition(startPosition);

        for (int index = 1; index < lines.size(); index++) {
            position = getLine(index).nextPosition(position);
        }

        return position;
    }
}
