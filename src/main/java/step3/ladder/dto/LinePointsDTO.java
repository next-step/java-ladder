package step3.ladder.dto;

import java.util.Collections;
import java.util.List;

public class LinePointsDTO {
    private final List<Boolean> points;

    public LinePointsDTO(List<Boolean> points) {
        this.points = Collections.unmodifiableList(points);
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
