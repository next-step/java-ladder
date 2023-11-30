package nextstep.ladder.strategy;


import nextstep.ladder.domain.Direction;

import java.util.List;

public class TestDirectionStrategy implements DirectionStrategy {

    private final List<Direction> directions;

    public TestDirectionStrategy(List<Direction> directions) {
        this.directions = directions;
    }

    @Override
    public Direction direction() {
        System.out.println("test:" + directions);
        return directions.remove(0);
    }
}
