package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Ladder {
    private static final int LADDER_MIN_COUNT = 2;
    private List<Line> lines;

    public Ladder(int playersCount, int height) {
        if (height < LADDER_MIN_COUNT) {
            throw new IllegalArgumentException("사다리 높이는 최소 " + LADDER_MIN_COUNT + "가 되어야 합니다.");
        }
        this.lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(new Line(playersCount));
        }
    }

    public String search(int index) {
        for (Line line : lines) {
           index = line.search(index);
        }
        Result result = new Result();
        return result.get(index);
    }

    public int size() {
        return lines.size();
    }

    public Stream<Line> stream() {
        return lines.stream();
    }
}
