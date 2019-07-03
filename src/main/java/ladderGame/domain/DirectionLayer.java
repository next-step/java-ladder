package ladderGame.domain;

import ladderGame.util.RungsGenerator;

import java.util.ArrayList;
import java.util.List;

public class DirectionLayer {

    private final static int ONE_RUNG = 1;
    private final static Boolean LIMIT_BOUNDARY_RUNG = false;

    private List<Direction> directions;

    private DirectionLayer(List<Boolean> rungs) {
        directions = new ArrayList<>();
        rungs.stream()
                .reduce(LIMIT_BOUNDARY_RUNG, this::buildDirection);
        directions.add(lastDirection(rungs));
    }

    public static DirectionLayer ofGenerator(int numberOfPlayer, RungsGenerator rungsGenerator) {
        List<Boolean> generate = rungsGenerator.generate(numberOfPlayer - ONE_RUNG);
        return new DirectionLayer(generate);
    }

    public Direction getDirections(int position) {
        return directions.get(position);
    }

    public List<Direction> getDirections() {
        return directions;
    }

    private Boolean buildDirection(Boolean left, Boolean right) {
        directions.add(Direction.decide(left, right));
        return right;
    }

    private Direction lastDirection(List<Boolean> rungs) {
        Boolean lastElement = getLastElement(rungs);
        if (lastElement) {
            return Direction.LEFT;
        }
        return Direction.STRAIGHT;
    }

    private Boolean getLastElement(List<Boolean> rungs) {
        return rungs.get(rungs.size() - 1);
    }

}
