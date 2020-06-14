package ladder.domain.ladder;

import java.util.Collections;
import java.util.List;

public class Lines {

    private final List<Line> lines;

    private Lines(final List<Line> lines){
        validate(lines);
        this.lines = lines;
    }

    public static Lines create(final List<Line> lines) {
        return new Lines(lines);
    }

    public List<Line> getLineList() {
        return Collections.unmodifiableList(lines);
    }

    private static void validate(List<Line> lines) {
        if (lines == null) {
            throw new IllegalArgumentException("lines 의 값이 null 입니다.");
        }
    }
}
