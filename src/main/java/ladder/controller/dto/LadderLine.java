package ladder.controller.dto;

import java.util.List;

public class LadderLine {

    private final List<Boolean> points;

    public LadderLine(List<Boolean> points) {
        this.points = points;
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
