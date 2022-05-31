package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import nextstep.ladder.exception.LadderLineNullException;
import nextstep.ladder.generator.PositionGenerator;

public class Line {
    private static final int ONE = 1;

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
//        validateLinePositionOverlap(positions);
    }

    private void validateNullAndEmpty(List<Position> positions) {
        if (positions == null || positions.isEmpty()) {
            throw new LadderLineNullException();
        }
    }

    private static List<Position> createLine(PositionGenerator productionStrategy, int countOfPosition) {
        List<Position> positions = new ArrayList<>();

        Position position = createFirstLine(productionStrategy, positions);
        positions.add(position);

        for (int i = ONE; i < countOfPosition - ONE; i++) {
            position = position.next(productionStrategy);
            positions.add(position);
        }

        positions.add(position.last());

        return positions;
    }

    private static Position createFirstLine(PositionGenerator productionStrategy, List<Position> positions) {
        return Position.first(productionStrategy.decideLineProduction());
    }

    public int ride(int position) {
        return positions.get(position).ride();
    }

    public List<Position> getPositions() {
        return positions;
    }
}
