package ladder.domain;

import ladder.view.exception.InvalidLadderHeightException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ladder {
    private static final int LADDER_HEIGHT_MIN = 1;

    private final List<Line> lines;
    private final LadderResult ladderResult;

    private Ladder(int height, LadderResult ladderResult) {
        this.ladderResult = ladderResult;
        this.lines = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            lines.add(new Line(ladderResult.getWidth()));
        }
    }

    public static Ladder getInstance(int height, LadderResult ladderResult) {
        if (height < LADDER_HEIGHT_MIN) {
            throw new InvalidLadderHeightException();
        }

        return new Ladder(height, ladderResult);
    }

    public int getHeight() {
        return this.lines.size();
    }

    public List<Line> getLines() {
        return lines.stream()
                .map(Line::getNewInstance)
                .collect(Collectors.toList());
    }

    public LadderResult getLadderResult() {
        return LadderResult.getNewInstance(ladderResult);
    }
}
