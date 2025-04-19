package nextstep.ladder;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lines {
    private final List<Line> lines;

    private Lines(List<Line> lines) {
        this.lines = lines;
    }

    public static Lines of(int height, int playerCount) {
        if (height < 1) {
            throw new IllegalArgumentException("높이는 1 이상이어야 합니다.");
        }

        List<Line> lines = IntStream.range(0, height)
                .mapToObj(it -> new Line(playerCount, new Random()))
                .collect(Collectors.toUnmodifiableList());

        return new Lines(lines);
    }

    public List<Line> getLines() {
        return lines;
    }

    public int calculateLastPosition(int playerIndex) {
        int cursor = playerIndex;

        for (Line line : lines) {
            cursor = line.calculateNextPosition(cursor);
        }

        return cursor;
    }
}
