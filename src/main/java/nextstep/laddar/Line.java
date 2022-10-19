package nextstep.laddar;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {
    private final List<Boolean> positions;

    public Line(int countOfPerson) {
        this.positions = IntStream.range(0, countOfPerson)
                .mapToObj((i) -> false)
                .collect(Collectors.toList());
    }


    public void putHorizontalLine(int position) {
        if (hasHorizontalLine(position)) {
            throw new IllegalStateException("해당 위치에는 이미 다리가 존재합니다.");
        }
        if (!hasNearHorizontalLine(position)) {
            this.positions.set(position, true);
        }
    }

    public boolean hasNearHorizontalLine(int position) {
        if (position > 0) {
            return positions.get(position - 1).equals(true);
        }
        if (position < positions.size() - 1) {
            return positions.get(position + 1).equals(true);
        }
        return false;
    }

    public boolean hasHorizontalLine(int position) {
        if (position >= positions.size()) {
            throw new IllegalArgumentException("해당 위치에는 다리를 놓을 수 없습니다.");
        }
        return positions.get(position).equals(true);
    }

    public void makeHorizontalLines(BooleanGenerator booleanGenerator) {
        for (int idx = 0; idx < positions.size(); idx++) {
            if (hasHorizontalLine(idx)) {
                continue;
            }
            if (booleanGenerator.generate()) {
                putHorizontalLine(idx);
            }
        }
    }
}

