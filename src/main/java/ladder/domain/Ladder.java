package ladder.domain;

import java.util.*;

public class Ladder {

    private final List<LadderLine> ladderLines;

    private Ladder(List<LadderLine> ladderLines) {
        this.ladderLines = ladderLines;
    }

    private Ladder(Width width, Height height) {
        this(ladderLines(width, height));
    }

    public static Ladder create(Width width, Height height) {
        return new Ladder(width, height);
    }

    public static Ladder create(LadderLine... ladderLines) {
        return new Ladder(Arrays.asList(ladderLines));
    }

    public List<LadderLine> getLadderLines() {
        return Collections.unmodifiableList(ladderLines);
    }

    private static List<LadderLine> ladderLines(Width width, Height height) {
        final List<LadderLine> ladderLines = new ArrayList<>(height.getLength());
        for (int i = 0; i < height.getLength(); i++) {
            ladderLines.add(LadderLine.create(width));
        }
        return ladderLines;
    }

    public int getHeight() {
        return this.ladderLines.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladder ladder = (Ladder) o;
        return Objects.equals(ladderLines, ladder.ladderLines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladderLines);
    }
}
