package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Lines {

    private final List<Line> lines;

    private Lines(List<Line> lines) {
        this.lines = lines;
    }

    public static Lines newInstance(List<Line> lines) {
        validate(lines);
        return new Lines(lines);
    }

    private static void validate(List<Line> lines) {
        if (lines == null || lines.size() == 0) {
            throw new IllegalArgumentException("라인 목록이 존재하지 않습니다.");
        }

        if (lines.stream().anyMatch(Objects::isNull)) {
            throw new IllegalArgumentException("존재하지 않는 라인이 포함되어 있습니다.");
        }
    }

    public Position moveAll(Position position) {
        for (Line line : this.lines) {
            position = line.move(position);
        }
        return position;
    }

    public List<Line> toList() {
        return Collections.unmodifiableList(lines);
    }
}
