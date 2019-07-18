package ladder.domain;

import ladder.LadderLine;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderLines {
    private static final IndexOutOfBoundsException
            INDEX_OUT_OF_BOUNDS_EXCEPTION = new IndexOutOfBoundsException("the index isn't bigger than ladder lines size");
    private final List<LadderLine> ladderLines;

    private LadderLines(List<LadderLine> ladderLines) {
        this.ladderLines = new ArrayList<>(ladderLines);
    }

    public static LadderLines of(int countOfPerson, int ladderHeight) {
        List<LadderLine> ladderLines = createLadderLines(countOfPerson, ladderHeight);
        return new LadderLines(ladderLines);
    }

    public int computeRewardPosition(int beginPosition) {
        int nextPosition = beginPosition;

        for (LadderLine ladderLine : this.ladderLines) {
            nextPosition = ladderLine.computeNextPosition(nextPosition);
        }

        return nextPosition;
    }

    public List<Boolean> moveResultsAt(int index) {
        if (index >= this.ladderLines.size()) {
            throw INDEX_OUT_OF_BOUNDS_EXCEPTION;
        }
        return this.ladderLines.get(index).getColumnMoveResults();
    }

    public int size() {
        return this.ladderLines.size();
    }

    private static List<LadderLine> createLadderLines(int countOfPerson, int ladderHeight) {
        return IntStream.range(0, ladderHeight)
                        .mapToObj(index -> LadderLine.of(countOfPerson))
                        .collect(Collectors.toList());
    }
}
