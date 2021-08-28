package nextstep.ladder.domain;

import nextstep.ladder.domain.line.Line;
import nextstep.ladder.exception.OutOfRangeException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Board {

    private static final int MIN_LADDER_HEIGHT = 1;
    private static final int ZERO = 0;
    private static final int ONE = 1;

    private List<Line> lines = new ArrayList<>();

    private Board() {

    }

    private Board(List<Line> lines) {
        validateLadderHeight(lines.size());

        this.lines = lines;
    }

    public static Board from(List<Line> lines) {
        return new Board(lines);
    }

    private void validateLadderHeight(int ladderHeight) {
        if (ladderHeight < MIN_LADDER_HEIGHT) {
            throw OutOfRangeException.shouldGreaterOrEqualThan(ladderHeight, MIN_LADDER_HEIGHT);
        }
    }

    public Map<Integer, Integer> play() {
        return IntStream.range(ZERO, lines.get(0).getSize())
                .boxed()
                .collect(Collectors.toMap(Function.identity(), this::getResult));
    }

    private int getResult(int inputIndex) {
        for (Line line : lines) {
            if (line.isExistPoint(inputIndex)) {
                inputIndex--;
                continue;
            }
            if (line.isExistPoint(inputIndex + ONE)) {
                inputIndex++;
            }
        }
        return inputIndex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Board)) return false;
        Board board = (Board) o;
        return Objects.equals(lines, board.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }

    @Override
    public String toString() {
        return lines.stream()
                .map(Line::toString)
                .collect(Collectors.joining("\n"));
    }
}
