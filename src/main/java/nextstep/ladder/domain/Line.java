package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Boolean> points;

    private Line(List<Boolean> points) {
        this.points = points;
    }

    public static Line createLine(int participantsCount) {
        List<Boolean> newPoints = new ArrayList<>();
        for (int i = 0; i < participantsCount - 1; i++) {
            newPoints.add(false);
        }
        return new Line(newPoints);
    }

    
}
