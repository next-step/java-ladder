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

    public boolean checkHeight(int height) {
        return this.lines.size() == height;
    }

    public Line getLine(int position) {
        if (this.lines.size() < position + 1) {
            return null;
        }

        return this.lines.get(position);
    }

    public int getResultPosition(int startPosition) {
        int position = getLine(0).move(startPosition);

        for (int index = 1; index < lines.size(); index++) {
            position = getLine(index).move(position);
        }

        return position;
    }
}
