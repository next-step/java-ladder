package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<LadderLine> ladderLines;

    public Ladder(int height, int width, LadderLineGenerator ladderLineGenerator) {
        if (height < 1 || width < 1) {
            throw new IllegalArgumentException("Height and width must be at least 1.");
        }

        this.ladderLines = IntStream.range(0, height)
                .mapToObj(i -> new LadderLine(ladderLineGenerator.generateLadderLine(width)))
                .collect(Collectors.toList());
    }

    public int height() {
        return ladderLines.size();
    }

    public int width() {
        if (ladderLines.isEmpty()) {
            return 0;
        }
        return ladderLines.get(0).size();
    }

    public LadderLine getLadderLine(int index) {
        if (index < 0 || index >= ladderLines.size()) {
            throw new IllegalArgumentException("Invalid index");
        }
        return ladderLines.get(index);
    }
}
