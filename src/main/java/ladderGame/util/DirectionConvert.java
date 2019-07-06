package ladderGame.util;

import ladderGame.domain.Direction;

import java.util.ArrayList;
import java.util.List;

public class DirectionConvert {

    private List<Direction> directions;

    private DirectionConvert() {
        this.directions = new ArrayList<>();
    }

    static DirectionConvert newInstance() {
        return new DirectionConvert();
    }

    public List<Direction> parse(List<Boolean> rungs) {
        rungs.stream()
                .reduce(this::buildDirection)
                .orElseThrow(() -> new IllegalArgumentException(""));
        return directions;
    }

    private Boolean buildDirection(Boolean left, Boolean current) {
        directions.add(Direction.decide(left, current));
        return current;
    }
}
