package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Lines {

    private static final String EMPTY_LINE = "사다리 정보가 비어있습니다.";

    private final List<Line> lines;

    public Lines(List<Line> lines) {
        if(lines.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_LINE);
        }
        this.lines = new ArrayList<>(lines);
    }

    public int size() {
        return this.lines.size();
    }
}
