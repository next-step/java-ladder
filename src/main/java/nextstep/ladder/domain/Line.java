package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import nextstep.ladder.exception.LadderLineOverLapException;
import nextstep.ladder.generator.ProductionGenerator;

public class Line {
    private static final int FIRST_POSITION_OF_LADDER_LINE = 0;
    private static final int PREVIOUS_POSITION = 1;
    private static final int FIRST_SPAWN_LOCATION = 1;

    private static final String LADDER_LINE_OVERLAP_ERROR_MESSAGE = "사다리 라인 위치가 겹쳐서 생성될 수 없습니다.";
    private static final String LADDER_LINE_NULL_OR_EMPTY_ERROR_MESSAGE = "사다리 라인이 비어있습니다.";

    private final List<Position> positions;

    private Line(List<Position> positions) {
        validate(positions);
        this.positions = positions;
    }

    private void validate(List<Position> positions) {
        validateNullAndEmpty(positions);
        validateLinePositionOverlap(positions);
    }

    private void validateNullAndEmpty(List<Position> positions) {
        if(positions == null || positions.isEmpty()) {
            throw new IllegalArgumentException(LADDER_LINE_NULL_OR_EMPTY_ERROR_MESSAGE);
        }
    }

    private void validateLinePositionOverlap(List<Position> positions) {
        for(int position = FIRST_SPAWN_LOCATION; position < positions.size(); position++) {
            comparePosition(positions, position);
        }
    }

    private void comparePosition(List<Position> positions, int position) {
        Position previousPosition = positions.get(position - PREVIOUS_POSITION);
        Position currentPosition = positions.get(position);

        if(previousPosition.hasValue() && currentPosition.hasValue()) {
            throw new LadderLineOverLapException(LADDER_LINE_OVERLAP_ERROR_MESSAGE);
        }
    }

    public static Line create(ProductionGenerator productionStrategy, int countOfPosition) {
        return create(createLine(productionStrategy, countOfPosition));
    }

    public static Line create(List<Position> positions) {
        return new Line(positions);
    }

    private static List<Position> createLine(ProductionGenerator productionStrategy, int countOfPosition) {
        List<Position> positions = new ArrayList<>();

        for(int position = 0; position < countOfPosition; position++) {
            positions.add(decidePositionProduction(positions, productionStrategy, position));
        }

        return positions;
    }

    private static Position decidePositionProduction(List<Position> positions, ProductionGenerator productionStrategy, int position) {
        if(position == FIRST_POSITION_OF_LADDER_LINE) {
            return new Position(false);
        }

        if(positions.get(position - PREVIOUS_POSITION).hasValue()) {
            return new Position(false);
        }

        return new Position(productionStrategy.decideLineProduction());
    }


    public List<Position> getPositions() {
        return positions;
    }
}
