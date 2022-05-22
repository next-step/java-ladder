package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import nextstep.ladder.exception.LadderLineNullException;
import nextstep.ladder.exception.LadderLineOverLapException;
import nextstep.ladder.generator.PositionGenerator;

public class Line {
    private static final int FIRST_POSITION_OF_LADDER_LINE = 0;
    private static final int FIRST_SPAWN_LOCATION = 1;
    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int DISTANCE_MOVED = 1;

    private final List<Boolean> positions;

    public Line(List<Boolean> positions) {
        validate(positions);
        this.positions = positions;
    }

    public Line(PositionGenerator productionStrategy, int countOfPosition) {
        this(createLine(productionStrategy, countOfPosition));
    }

    private void validate(List<Boolean> positions) {
        validateNullAndEmpty(positions);
        validateLinePositionOverlap(positions);
    }

    private void validateNullAndEmpty(List<Boolean> positions) {
        if (positions == null || positions.isEmpty()) {
            throw new LadderLineNullException();
        }
    }

    private void validateLinePositionOverlap(List<Boolean> positions) {
        for (int position = FIRST_SPAWN_LOCATION; position < positions.size(); position++) {
            comparePosition(positions, position);
        }
    }

    private void comparePosition(List<Boolean> positions, int position) {
        boolean previousPosition = positions.get(position - ONE);
        boolean currentPosition = positions.get(position);

        if (previousPosition && currentPosition) {
            throw new LadderLineOverLapException();
        }
    }

    private static List<Boolean> createLine(PositionGenerator productionStrategy, int countOfPosition) {
        List<Boolean> positions = new ArrayList<>();

        for (int position = ZERO; position < countOfPosition; position++) {
            positions.add(decidePositionProduction(positions, productionStrategy, position));
        }

        return positions;
    }

    private static Boolean decidePositionProduction(List<Boolean> positions, PositionGenerator productionStrategy,
                                                    int position) {
        if (position == FIRST_POSITION_OF_LADDER_LINE) {
            return false;
        }

        if (positions.get(position - ONE)) {
            return false;
        }

        return productionStrategy.decideLineProduction();
    }

    public int ride(int position) {
        if (positions.get(position)) {
            return position - DISTANCE_MOVED;
        }

        if (position + DISTANCE_MOVED < positions.size() && positions.get(position + DISTANCE_MOVED)) {
            return position + DISTANCE_MOVED;
        }

        return position;
    }

    public List<Boolean> getPositions() {
        return positions;
    }
}
