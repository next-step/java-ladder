package nextstep.ladder;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lines {
    private final List<Line> lines;

    public Lines(int height, int playerCount) {
        if (height < 1) {
            throw new IllegalArgumentException("높이는 1 이상이어야 합니다.");
        }

        this.lines = IntStream.range(0, height)
                .mapToObj(it -> new Line(playerCount, new Random()))
                .collect(Collectors.toUnmodifiableList());
    }

    public List<Line> getLines() {
        return lines;
    }
}
