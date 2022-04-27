package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private List<Boolean> points = new ArrayList<>();

    public Line(int countOfPlayer) {
        this.points = LineGenerator.createLine(countOfPlayer);
    }

    public List<Boolean> getPoints() {
        return new ArrayList<>(points);
    }
}
