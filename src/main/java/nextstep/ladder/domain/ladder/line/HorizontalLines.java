package nextstep.ladder.domain.ladder.line;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class HorizontalLines {

    List<HorizontalLine> horizontalLines;

    public HorizontalLines(List<HorizontalLine> horizontalLines) {
        this.horizontalLines = horizontalLines;
    }

    public Optional<HorizontalLine> findByIndex(int index) {
        return horizontalLines.stream()
                .filter(horizontalLine -> horizontalLine.getIndex() == index)
                .findFirst();
    }

    public boolean contains(HorizontalLine horizontalLine) {
        return horizontalLines.contains(horizontalLine);
    }

    public int size() {
        return horizontalLines.size();
    }

    public Stream<HorizontalLine> stream() {
        return horizontalLines.stream();
    }

    public void remove(HorizontalLine horizontalLine) {
        horizontalLines.remove(horizontalLine);
    }
}
