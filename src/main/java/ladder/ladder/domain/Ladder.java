package ladder.ladder.domain;

import java.util.List;

public class Ladder {
    private static final int MIN_HEIGHT = 1;
    private static final int MIN_WIDTH = 2;

    private final List<LadderLine> ladderLines;

    private Ladder(int height, int width) {
        validate(height, width);
        this.ladderLines = LadderLineGenerator.generate(height, width);
    }

    public static Ladder of(int height, int width) {
        return new Ladder(height, width);
    }

    public List<LadderLine> getLadderLines() {
        return ladderLines;
    }

    public int getHeight() {
        return ladderLines.stream()
                .map(LadderLine::getLines)
                .map(List::size)
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

    private void validate(int height, int width) {
        if (height < MIN_HEIGHT) {
            throw new InvalidHeightException();
        }
        if (width < MIN_WIDTH) {
            throw new NotEnoughCountOfPersonException();
        }
    }

    @Override
    public String toString() {
        return "Ladder{" +
                "ladderLines=" + ladderLines +
                '}';
    }
}
