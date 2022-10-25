package laddergame.domain;

import laddergame.domain.linepainter.LinePainter;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Line {
    private final List<Boolean> values;

    public Line(List<Boolean> values) {
        validateLine(values);
        this.values = values;
    }

    public static Line of(int numberOfPerson, LinePainter painter) {
        return new Line(painter.draw(numberOfPerson));
    }

    private void validateLine(List<Boolean> values) {
        if (values == null || values.isEmpty()) {
            throw new IllegalArgumentException("빈 값은 입력이 불가능합니다.");
        }
        if (values.get(0)) {
            throw new IllegalArgumentException("첫번째 값은 사다리를 그릴 수 없습니다.");
        }
        if (isDuplicatePoint(values)) {
            throw new IllegalArgumentException("연속된 사다리는 그릴 수 없습니다.");
        }
    }

    private static boolean isDuplicatePoint(List<Boolean> values) {
        return IntStream.range(1, values.size())
                .anyMatch(i -> values.get(i - 1) && values.get(i));
    }

    public List<Boolean> getValues() {
        return Collections.unmodifiableList(values);
    }

    public int nextIndex(int index) {
        if (index > 0 && values.get(index)) {
           return index-1;
        }

        if (index < values.size()-1 && values.get(index + 1)) {
            return index+1;
        }
        return index;
    }
}
