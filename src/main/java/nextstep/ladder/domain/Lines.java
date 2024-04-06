package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    public static Lines of(int countOfPerson, int height) {
        List<Line> lines = IntStream.range(0, height)
                .mapToObj(i -> Line.createLine(countOfPerson))
                .collect(Collectors.toList());
        return new Lines(lines);
    }

    public int getHeight() {
        return lines.size();
    }

    public Line getLine(int targetHeight) {
        return lines.get(targetHeight);
    }
}
