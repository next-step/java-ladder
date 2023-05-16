package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final LinesGenerator linesGenerator;
    private final List<Lines> heightLines;

    public Ladder(final LinesGenerator linesGenerator, final int width, final int height) {
        this.linesGenerator = linesGenerator;
        this.heightLines = install(width, height);
    }

    private List<Lines> install(final int width, final int height) {
        List<Lines> rowLines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            rowLines.add(linesGenerator.generate(width, i));
        }
        return rowLines;
    }

    public boolean hasLine(final Line line, final int height) {
        return heightLines.get(height).hasLine(line);
    }

    public int height() {
        return heightLines.size();
    }

}
