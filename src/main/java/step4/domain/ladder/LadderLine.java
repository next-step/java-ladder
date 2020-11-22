package step4.domain.ladder;

import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class LadderLine {
    private final List<Line> ladderLine;

    public LadderLine(List<Line> ladderLine) {
        this.ladderLine = Collections.unmodifiableList(ladderLine);
    }

    public void forEach(Consumer<Line> function) {
        ladderLine.forEach(function);
    }

    public Line get(int index) {
        if (ladderLine.size() <= index) {
            return null;
        }
        return ladderLine.get(index);
    }
}
