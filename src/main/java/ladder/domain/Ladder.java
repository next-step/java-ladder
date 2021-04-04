package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {
    private static final int MIN_HEIGHT = 1;
    private final List<Line> ladder = new ArrayList<>();

    public Ladder(int countOfPerson, int height) {
        valid(height);
        IntStream.range(0, height)
            .forEach((index) -> ladder.add(new Line(countOfPerson)));
    }

    private void valid(int height) {
        if (height < MIN_HEIGHT) {
            throw new IllegalArgumentException("사디리 높이는 최소 1이상이여야 합니다.");
        }
    }

    public void draw(ConnectStrategy connectStrategy) {
        ladder.forEach(line -> line.draw(connectStrategy));
    }

    public List<Line> getLadder() {
        return this.ladder;
    }
}
