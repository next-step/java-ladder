package ladder.model;

import ladder.util.RungGenerator;

import java.util.ArrayList;
import java.util.List;

public class Layer {

    private static final int ONE_RUNG = 1;
    private static final Boolean LEFT_BOUNDARY_RUNG = Boolean.FALSE;
    private final List<Direction> directions;

    public Layer(final List<Boolean> rungs) {
        directions = new ArrayList<>();
        rungs.stream().reduce(LEFT_BOUNDARY_RUNG, this::makeDirection);
        directions.add(lastDirection(rungs));
    }

    static Direction lastDirection(List<Boolean> rungs) {
        boolean lastRung = rungs.get(rungs.size() - 1);
        if (lastRung) {
            return Direction.LEFT;
        }
        return Direction.PASS;
    }

    Boolean makeDirection(Boolean current, Boolean right) {
        directions.add(Direction.of(current, right));
        return right;
    }

    public static Layer of(RungGenerator rungGenerator, int countOfPlayers) {
        List<Boolean> rungs = rungGenerator.generate(countOfPlayers - ONE_RUNG);
        return new Layer(rungs);
    }

    public List<Direction> getDirections() {
        return this.directions;
    }
}
