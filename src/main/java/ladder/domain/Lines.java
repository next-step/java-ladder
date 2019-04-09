package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Lines {
    private List<Line> values;

    public Lines(final List<Line> values) {
        this.values = new ArrayList<>(values);
    }

    public Line getLine(final int height) {
        return this.values.get(height);
    }

    public int getHeight() {
        return this.values.size();
    }
}
