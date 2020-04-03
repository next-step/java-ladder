package ladder.domain;

import lombok.Getter;

import java.util.List;

public class Line {
    @Getter
    private List<Boolean> points;

    public Line(List<Boolean> points) {
        this.points = points;
    }
}
