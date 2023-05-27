package nextstep.ladder.domain;


import java.util.Collections;
import java.util.List;

public class Ladder {

    private static final String HEIGHT_ERROR_MESSAGE = "높이는 0보다 커야 합니다.";

    private List<Line> lines;

    public Ladder(int height, int width) {
        if (1 > height) {
            throw new IllegalArgumentException(HEIGHT_ERROR_MESSAGE);
        }
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(this.lines);
    }


}
