package ladder.backEnd.domain;

import java.util.Collections;
import java.util.List;

public class Lines {

    private List<Line> values;

    public Lines(List<Line> lines) {
        this.values = lines;
    }

    public List<Line> getValues() {
        return Collections.unmodifiableList(values);
    }

    @Override
    public String toString() {
        return "Lines{" +
                "lines=" + values +
                '}';
    }
}
