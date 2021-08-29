package nextstep.ladder.domain.impl.board;

import nextstep.ladder.domain.engine.Board;
import nextstep.ladder.domain.engine.PlayResult;
import nextstep.ladder.domain.impl.line.LadderLine;
import nextstep.ladder.exception.OutOfRangeException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderBoard implements Board {

    private static final int MIN_LADDER_HEIGHT = 1;
    private static final int ZERO = 0;

    private List<LadderLine> ladderLines = new ArrayList<>();

    private LadderBoard() {

    }

    private LadderBoard(List<LadderLine> ladderLines) {
        validateLadderHeight(ladderLines.size());

        this.ladderLines = ladderLines;
    }

    public static LadderBoard from(List<LadderLine> ladderLines) {
        return new LadderBoard(ladderLines);
    }

    private void validateLadderHeight(int ladderHeight) {
        if (ladderHeight < MIN_LADDER_HEIGHT) {
            throw OutOfRangeException.shouldGreaterOrEqualThan(ladderHeight, MIN_LADDER_HEIGHT);
        }
    }

    public PlayResult play() {
        Map<Integer, Integer> result = IntStream.range(ZERO, ladderLines.get(0).getSize())
                .boxed()
                .collect(Collectors.toMap(Function.identity(), this::getResult));
        return new PlayResult(result);
    }

    private int getResult(int inputIndex) {
        for (LadderLine ladderLine : ladderLines) {
            inputIndex = ladderLine.move(inputIndex);
        }
        return inputIndex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LadderBoard)) return false;
        LadderBoard ladderBoard = (LadderBoard) o;
        return Objects.equals(ladderLines, ladderBoard.ladderLines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladderLines);
    }

    @Override
    public String toString() {
        return ladderLines.stream()
                .map(LadderLine::toString)
                .collect(Collectors.joining("\n"));
    }
}
