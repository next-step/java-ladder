package laddergame.domain.ladder;

import java.util.List;

import static laddergame.domain.ladder.Direction.*;

public enum Link {
    LINKED(List.of(RIGHT, LEFT)),
    UNLINKED(List.of(DOWN, DOWN));

    private final List<Direction> directions;

    Link(List<Direction> directions) {
        this.directions = directions;
    }

    public boolean isLinked() {
        return this == LINKED;
    }

    public boolean isUnLinked() {
        return this == UNLINKED;
    }

    public int rightDirectionValue() {
        return directions.get(0).value();
    }

    public int leftDirectionValue() {
        return directions.get(1).value();
    }

}
