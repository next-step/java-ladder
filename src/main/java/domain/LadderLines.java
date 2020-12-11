package domain;

import java.util.List;
import java.util.function.Consumer;

public class LadderLines {
    private final List<LadderLine> ladderLines;

    public LadderLines(List<LadderLine> ladderLines) {
        this.ladderLines = ladderLines;
    }

    public int size() {
        return ladderLines.size();
    }

    public LadderLine get(int i) {
        return ladderLines.get(i);
    }

    public void forEachLadderLine(Consumer<? super LadderLine> consumer) {
        ladderLines.forEach(consumer);
    }
}
