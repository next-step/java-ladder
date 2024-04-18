package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Lines {

    private final List<Line> lines;

    private Lines(List<Line> lines) {
        validate(lines);
        this.lines = lines;
    }

    private void validate(List<Line> lines) {
        if (lines == null || lines.isEmpty()) {
            throw new IllegalArgumentException("사다리 높이는 1 이상이어야 합니다.");
        }
    }

    public static Lines of(int numberOfPlayers, int height) {
        return IntStream.range(0, height)
                .mapToObj(i -> LineBuilder.buildWithRandomPoints(numberOfPlayers))
                .collect(collectingAndThen(toList(), Lines::new));
    }

    public int getHeight() {
        return lines.size();
    }

    public Line getLine(int targetHeight) {
        return lines.get(targetHeight);
    }
}
