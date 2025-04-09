package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<LadderLine> ladderLines;
    private final Integer width;

    public Ladder(int height, int width, LadderLineGenerator ladderLineGenerator) {
        if (height < 1 || width < 1) {
            throw new IllegalArgumentException("Height and width must be at least 1.");
        }

        this.width = width;
        this.ladderLines = initializeLadderLines(height, width, ladderLineGenerator);
    }

    public Ladder(List<LadderLine> ladderLines) {
        if (ladderLines == null || ladderLines.isEmpty()) {
            throw new IllegalArgumentException("Ladder lines cannot be null or empty.");
        }
        this.ladderLines = ladderLines;
        this.width = ladderLines.get(0).size() + 1;
    }

    public int height() {
        return ladderLines.size();
    }

    public int width() {
        return width;
    }

    public List<LadderLine> getLadderLinesCopy() {
        return ladderLines.stream()
                .map(LadderLine::copy)
                .collect(Collectors.toList());
    }

    public Position traverse(Position position) {
        for (LadderLine ladderLine : ladderLines) {
            position = ladderLine.move(position);
        }
        return position;
    }

    private List<LadderLine> initializeLadderLines(int height, int width, LadderLineGenerator ladderLineGenerator) {
        return IntStream.range(0, height)
                .mapToObj(i -> new LadderLine(ladderLineGenerator.generateLadderLine(width - 1)))
                .collect(Collectors.toList());
    }
}
