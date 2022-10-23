package nextstep.laddar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Line {
    private final List<Boolean> positions = new ArrayList<>();
    private final BooleanGenerator booleanGenerator;

    public Line(int countOfPerson, BooleanGenerator booleanGenerator) {
        this.booleanGenerator = booleanGenerator;
        for (int i = 0; i < countOfPerson; i++) {
            this.positions.add(false);
        }
        for (int position = 0; position < this.positions.size(); position++) {
            positions.set(position, putHorizontalLine(position));
        }
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

    private void validateRangePosition(int pos) {
        if (pos >= positions.size() || pos < 0) {
            throw new IllegalArgumentException("해당 위치에는 다리를 놓을 수 없습니다.");
        }
    }

    public List<Boolean> getPositions() {
        return positions;
    }
}

