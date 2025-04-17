package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> lines;

    public Ladder(int height, int width) {
        validate(height, width);
        this.lines = IntStream.range(0, height)
                .mapToObj(i -> new Line(width))
                .collect(Collectors.toList());
    }

    private void validate(int height, int width) {
        if (height <= 0) {
            throw new IllegalArgumentException("사다리 높이는 1 이상이어야 합니다.");
        }

        if (width < 2) {
            throw new IllegalArgumentException("사다리는 최소 2명 이상의 플레이어가 있어야 생성 가능합니다.");
        }
    }

    public List<Line> getLines() {
        return lines;
    }
}
