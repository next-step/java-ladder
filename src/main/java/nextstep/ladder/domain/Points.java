package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Points {
    private static final String STICK = "|";
    private static final String EDGE = "-----";
    private static final String EMPTY = "     ";

    private final List<Boolean> points;

    public Points(List<Boolean> points) {
        this.points = points;
    }

    public String getPoint() {
        return this.points.stream()
                .map(this::getEdgeOrEmpty)
                .collect(Collectors.joining());
    }

    private String getEdgeOrEmpty(Boolean point) {
        if (point) {
            return STICK + EDGE;
        }

        return STICK + EMPTY;
    }
}
