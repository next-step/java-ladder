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

    private final List<Position> positions;

    public Line(List<Position> positions) {
        validate(positions);
        this.positions = positions;
    }

    public Line(PositionGenerator productionStrategy, int countOfPosition) {
        this(createLine(productionStrategy, countOfPosition));
    }

    private void validate(List<Position> positions) {
        validateNullAndEmpty(positions);
        validateLinePositionOverlap(positions);
    }

    private void validateNullAndEmpty(List<Position> positions) {
        if (positions == null || positions.isEmpty()) {
            throw new LadderLineNullException();
        }
    }

    private void validateLinePositionOverlap(List<Position> positions) {
        for (int position = FIRST_SPAWN_LOCATION; position < positions.size(); position++) {
            comparePosition(positions, position);
        }
    }

    private void comparePosition(List<Position> positions, int position) {
        Position previousPosition = positions.get(position - ONE);
        Position currentPosition = positions.get(position);

        if (previousPosition.hasValue() && currentPosition.hasValue()) {
            throw new LadderLineOverLapException();
        }
    }

    private static List<Position> createLine(PositionGenerator productionStrategy, int countOfPosition) {
        List<Position> positions = new ArrayList<>();

        for (int position = ZERO; position < countOfPosition; position++) {
            positions.add(decidePositionProduction(positions, productionStrategy, position));
        }

        return positions;
    }

    private static Position decidePositionProduction(List<Position> positions, PositionGenerator productionStrategy,
                                                     int position) {
        if (position == FIRST_POSITION_OF_LADDER_LINE) {
            return new Position(false);
        }

        if (positions.get(position - ONE).hasValue()) {
            return new Position(false);
        }

        return new Position(productionStrategy.decideLineProduction());
    }

    public int ride(int position) {
        if (positions.get(position).hasValue()) {
            return position - DISTANCE_MOVED;
        }

        if (position + DISTANCE_MOVED < positions.size() && positions.get(position + DISTANCE_MOVED).hasValue()) {
            return position + DISTANCE_MOVED;
        }

        return position;
    }

    public List<Position> getPositions() {
        return positions;
    }
}
