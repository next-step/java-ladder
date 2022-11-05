package nextstep.refactoring;

import nextstep.refactoring.strategy.BooleanGenerator;

import java.util.ArrayList;
import java.util.List;

public class Positions {
    public final List<Position> positions;

    public Positions(int countOfPerson, BooleanGenerator booleanGenerator) {
        validateCountOfPerson(countOfPerson);
        positions = new ArrayList<>();
        Position position = addFirstPosition(booleanGenerator);
        position = addMidPositions(countOfPerson, booleanGenerator, position);
        addLastPosition(countOfPerson, position);
    }

    private void validateCountOfPerson(int countOfPerson) {
        if (countOfPerson <= 0) {
            throw new IllegalArgumentException("참여한 사람의 수는 양수여야만 합니다.");
        }
    }

    private void addLastPosition(int countOfPerson, Position position) {
        if (countOfPerson >= 2) {
            positions.add(position.last());
        }
    }

    private Position addMidPositions(int countOfPerson, BooleanGenerator booleanGenerator, Position position) {
        for (int i = 1; i < countOfPerson - 1; i++) {
            position = position.next(booleanGenerator.generate());
            positions.add(position);
        }
        return position;
    }

    private Position addFirstPosition(BooleanGenerator booleanGenerator) {
        Position position = Position.first(booleanGenerator.generate());
        positions.add(position);
        return position;
    }

    public int move(int index) {
        validateWrongIndex(index);
        Position position = positions.get(index);
        return position.move();
    }

    private void validateWrongIndex(int index) {
        if (index < 0 || index >= positions.size()) {
            throw new IllegalArgumentException("접근할 수 없는 위치값입니다.");
        }
    }

    public List<Position> getPositions() {
        return positions;
    }
}
