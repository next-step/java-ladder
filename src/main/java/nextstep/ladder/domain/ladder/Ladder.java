package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.exception.OutOfRangeIndexException;
import nextstep.ladder.domain.ladder.size.LadderSize;
import nextstep.ladder.domain.ladder.size.LadderWidth;
import nextstep.ladder.domain.rule.WayRule;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static nextstep.ladder.utils.Validation.checkNotEmpty;
import static nextstep.ladder.utils.Validation.checkNotNull;

public class Ladder {

    private static final int MIN_INDEX = 0;
    private final List<LadderLine> ladderLines;

    public Ladder(List<LadderLine> ladderLines) {
        checkNotEmpty(ladderLines);
        this.ladderLines = ladderLines;
    }

    public static Ladder of(LadderSize ladderSize, WayRule wayRule) {
        checkNotNull(ladderSize, wayRule);

        int height = ladderSize.height();
        LadderWidth ladderWidth = ladderSize.getLadderWidth();
        return new Ladder(createLadderLines(height, ladderWidth, wayRule));
    }

    private static List<LadderLine> createLadderLines(int height, LadderWidth ladderWidth, WayRule wayRule) {
        return Stream.generate(() -> LadderLine.of(ladderWidth, wayRule))
                .limit(height)
                .collect(Collectors.toList());
    }

    public int move(int position) {
        checkRange(position);
        return movePerLine(position, MIN_INDEX);
    }

    private void checkRange(int position) {
        if (position < MIN_INDEX || position >= width()) {
            throw new OutOfRangeIndexException();
        }
    }

    private int movePerLine(int currentPosition, int currentHeight) {
        if (currentHeight == height()) {
            return currentPosition;
        }

        LadderLine currentLine = ladderLines.get(currentHeight);
        int nextIndex = currentLine.move(currentPosition);
        return movePerLine(nextIndex, ++currentHeight);
    }

    private int width() {
        LadderLine ladderLine = ladderLines.get(MIN_INDEX);
        return ladderLine.width();
    }

    private int height() {
        return ladderLines.size();
    }
}
