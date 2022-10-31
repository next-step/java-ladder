package game.dto;

import java.util.List;

public class LineDto {
    private final List<Boolean> points;

    public LineDto(List<Boolean> points) {
        this.points = points;
    }

    public List<Boolean> getLines() {
        return points;
    }
}
