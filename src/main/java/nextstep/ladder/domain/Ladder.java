package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final List<Lines> ladderLines;

    public Ladder(final LinesGenerator linesGenerator, final int width, final int height) {
        this.ladderLines = install(linesGenerator, width, height);
    }

    private List<Lines> install(final LinesGenerator linesGenerator, final int width, final int height) {
        List<Lines> heightLines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            heightLines.add(linesGenerator.generate(width, i));
        }
        return heightLines;
    }

    public boolean hasLine(final Line line) {
        return ladderLines.stream().anyMatch(lines -> lines.hasLine(line));
    }

    public int height() {
        return ladderLines.size();
    }

    public Position move(Position position) {
        for (Lines lines : ladderLines) {
            position = lines.move(position);
        }
        return position;
    }

}
