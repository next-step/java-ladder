package ladder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {

    private List<Boolean> bars;

    public Line(List<Boolean> bars) {
        this.bars = new ArrayList<>(bars);
    }

    public List<Boolean> getBars() {
        return Collections.unmodifiableList(bars);
    }
}
