package nextstep.ladder;

import nextstep.ladder.strategy.BooleanGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {
    private final List<Boolean> positions = new ArrayList<>();
    private final BooleanGenerator booleanGenerator;

    public Line(int countOfPerson, BooleanGenerator booleanGenerator) {
        this.booleanGenerator = booleanGenerator;
        initializePositions(countOfPerson);
        generateHorizontalLine();
    }

    public int goOneStep(int position) {
        if (hasLine(position)) {
            return moveRight(position);
        }

        if (hasLeftLine(position)) {
            return moveLeft(position);
        }

        return position;
    }


    private void initializePositions(int countOfPerson) {
        for (int i = 0; i < countOfPerson; i++) {
            this.positions.add(false);
        }
    }

    private void generateHorizontalLine() {
        for (int position = 0; position < this.positions.size(); position++) {
            positions.set(position, putHorizontalLine(position));
        }
    }

    private int moveLeft(int position) {
        if (canMoveLeft(position)) {
            return position - 1;
        }
        return position;
    }

    private boolean canMoveLeft(int position) {
        return position - 1 >= 0;
    }

    private int moveRight(int position) {
        if (canMoveRight(position)) {
            return position + 1;
        }
        return position;
    }

    private boolean canMoveRight(int position) {
        return position + 1 < this.positions.size();
    }

    private void validateRangePosition(int pos) {
        if (pos >= positions.size() || pos < 0) {
            throw new IllegalArgumentException("범위를 벗어나는 위치입니다.");
        }
    }

    private boolean hasLine(int position) {
        validateRangePosition(position);
        return positions.get(position);
    }

    private boolean putHorizontalLine(int position) {
        if (!hasNearHorizontalLine(position)) {
            return booleanGenerator.generate();
        }
        return false;
    }

    private boolean hasNearHorizontalLine(int position) {
        validateRangePosition(position);
        return hasLeftLine(position) || hasRightRine(position);
    }

    private boolean hasRightRine(int position) {
        return position < positions.size() - 1 && positions.get(position + 1).equals(true);
    }

    private boolean hasLeftLine(int position) {
        return position > 0 && positions.get(position - 1).equals(true);
    }
    public List<Boolean> getPositions() {
        return Collections.unmodifiableList(this.positions);
    }

}

