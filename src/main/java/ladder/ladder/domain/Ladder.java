package ladder.ladder.domain;

import ladder.player.domain.Players;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ladder {
    private static final int NUMBER_ONE = 1;
    private static final int MIN_HEIGHT = 1;
    private static final int START_INDEX = 0;

    private final int height;
    private final List<LadderLine> ladderLines;

    private Ladder(int height, int width) {
        validate(height);
        this.height = height;
        this.ladderLines = generate(width, height);
    }

    private Ladder(List<LadderLine> ladderLines) {
        this.ladderLines = ladderLines;
        this.height = ladderLines.get(START_INDEX)
                .getLines()
                .size();
    }

    public static Ladder of(int height, Players players) {
        return new Ladder(height, players.size());
    }

    public static Ladder of(LadderLine... ladderLines) {
        return new Ladder(Arrays.asList(ladderLines));
    }

    public List<LadderLine> generate(int width, int height) {
        List<LadderLine> allLines = new ArrayList<>();
        allLines.add(LadderLineGenerator.generateFirstLine(height));

        int lineCountExcludeFirstLine = Math.subtractExact(width, NUMBER_ONE);
        for (int i = NUMBER_ONE; i < lineCountExcludeFirstLine; i++) {
            int prevIndex = Math.subtractExact(i, NUMBER_ONE);
            allLines.add(LadderLineGenerator.generateInnerLine(allLines.get(prevIndex), height));
        }
        allLines.add(LadderLineGenerator.generateLastLine(height));
        return allLines;
    }

    public int move(int index) {
        for (int i = 0; i < height; i++) {
            index = moveIndex(index, i);
        }
        return index;
    }

    public List<LadderLine> getLadderLines() {
        return ladderLines;
    }

    public int getHeight() {
        return height;
    }

    private int moveIndex(int index, int height) {
        LadderLine startLadderLine = ladderLines.get(index);
        List<Line> movedLine = startLadderLine.getLines();

        if (isLink(height, movedLine)) {
            index = increase(index, isLink(height, movedLine));
        }

        if (index != START_INDEX && !isLink(height, movedLine)) {
            LadderLine prevLadderLine = ladderLines.get(index - NUMBER_ONE);
            List<Line> prevLine = prevLadderLine.getLines();
            index = decrease(index, isLink(height, prevLine));
        }

        return index;
    }

    private boolean isLink(int index, List<Line> lines) {
        return lines.get(index).isLink();
    }

    private int increase(int index, boolean currentLineLink) {
        if (currentLineLink) {
            index++;
        }
        return index;
    }

    private int decrease(int index, boolean prevLineLink) {
        if (prevLineLink) {
            index--;
        }
        return index;
    }

    private void validate(int height) {
        if (height < MIN_HEIGHT) {
            throw new InvalidHeightException();
        }
    }

}
