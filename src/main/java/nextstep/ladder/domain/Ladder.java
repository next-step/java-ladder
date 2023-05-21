package nextstep.ladder.domain;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {

    private static final String HEIGHT_ERROR_MESSAGE = "높이는 0보다 커야 합니다.";

    private List<Line> lines = new ArrayList<>();

    private int height;

    public Ladder(int height) {
        if (1 > height) {
            throw new IllegalArgumentException(HEIGHT_ERROR_MESSAGE);
        }
        this.height = height;
    }

    public void addLine(Line line) {
        lines.add(line);
    }

    public int getHeight() {
        return height;
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(this.lines);
    }

}
