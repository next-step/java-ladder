package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;

public class Line {
    private final List<Boolean> points;

    public Line(List<Boolean> points) {
        if (points.isEmpty()) {
            this.points = Collections.emptyList();
            return;
        }

        if (points.get(0)) {
            throw new IllegalArgumentException("Ladders cannot be connected first");
        }

        points.stream()
                .reduce((b1, b2) -> {
                    if (b1 && b2) {
                        throw new IllegalArgumentException("Ladders cannot be connected in series");
                    }
                    return b2;
                });

        this.points = points;
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
