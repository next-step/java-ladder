package nextstep;

import java.util.ArrayList;
import java.util.List;

public class Lines {
    private final List<Line> lines;

    public Lines(int vertical, int countOfPerson) {
        this.lines = new ArrayList<>();
        for (int i = 0; i < vertical; i++) {
            this.lines.add(new Line(countOfPerson));
        }
    }

    public void mark(int targetVertical) {
        try {
            this.lines.get(targetVertical).mark();
        } catch (IllegalArgumentException e) {
            this.lines.get(targetVertical).reMark(this.lines.get(targetVertical - 1));
        }

    }

    public void mark(int targetVertical, int targetHorizon) {
        this.lines.get(targetVertical).mark(targetHorizon);
    }

    public int size() {
        return this.lines.size();
    }

    public String lineString(int targetVertical) {
        return this.lines.get(targetVertical).lineString();
    }
}
