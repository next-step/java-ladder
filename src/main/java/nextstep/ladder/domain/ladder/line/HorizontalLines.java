package nextstep.ladder.domain.ladder.line;

import java.util.List;
import java.util.stream.Stream;

public class HorizontalLines {

    private static final int INDEX_LOWER_BOUND = 0;
    private List<HorizontalLine> horizontalLines;

    public HorizontalLines(List<HorizontalLine> horizontalLines) {
        this.horizontalLines = horizontalLines;
    }

    public boolean exist(int index) {
        return get(index).exist();
    }

    public HorizontalLine get(int index) {
        validateIndex(index);
        return horizontalLines.get(index);
    }

    public int size() {
        return horizontalLines.size();
    }

    public void remove(HorizontalLine horizontalLine) {
        int index = horizontalLines.indexOf(horizontalLine);
        horizontalLines.set(index, new HorizontalLine(false));
    }

    public Stream<HorizontalLine> stream() {
        return horizontalLines.stream();
    }

    private void validateIndex(int index) {
        if (exceedSize(index) || index < INDEX_LOWER_BOUND)
            throw new IllegalArgumentException("인덱스가 적절하지 않습니다");
    }

    private boolean exceedSize(int index) {
        return index >= size();
    }
}
