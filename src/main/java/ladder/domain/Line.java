package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {

    private List<Bar> bars;

    private Line(List<Bar> bars) {
        this.bars = new ArrayList<>(bars);
    }

    public static Line from(int numberOfPlayers) {
        LineMaker lineMaker = new LineMaker();
        return new Line(lineMaker.generateBars(numberOfPlayers));
    }

    public List<Bar> getBars() {
        return Collections.unmodifiableList(bars);
    }
}
