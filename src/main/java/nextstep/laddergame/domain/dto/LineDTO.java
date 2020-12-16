package nextstep.laddergame.domain.dto;

import nextstep.laddergame.domain.Line;

import java.util.List;

public class LineDTO {
    private List<Boolean> points;

    private LineDTO(List<Boolean> points) {
        this.points = points;
    }

    public static LineDTO from(Line line) {
        return new LineDTO(line.getPoints());
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
