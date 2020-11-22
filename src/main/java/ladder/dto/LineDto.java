package ladder.dto;

import java.util.List;

public class LineDto {
    private final List<PointDto> points;

    public LineDto(List<PointDto> points) {
        this.points = points;
    }

    public List<PointDto> getPoints() {
        return points;
    }
}
