package ladderstep4.ladder.domain;

import ladderstep4.ladder.enums.LadderPart;
import ladderstep4.ladder.util.function.MathFunction;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {
    public static final String INVALID_WIDTH_MESSAGE = "width는 짝수일 수 없습니다.";
    public static final String INVALID_PART_EVEN_RAIL_MESSAGE = "짝수 인덱스는 Rail이 와야합니다.";
    public static final String INVALID_PART_ODD_RUNG_MESSAGE = "홀수 인덱스는 Rung이나 EmptyRung 와야합니다.";

    private static final int MIN_WIDTH = 1;
    private static final int INDEX_ZERO = 0;
    private static final int MOVE_COUNT = 2;
    private static final int MOVE_CHECK_COUNT = 1;
    private static final int LADDER_PARTS_SIZE_TO_INDEX = 1;

    private final List<LadderPart> ladderParts;

    public Line(int width) {
        this(makeRandomLadderParts(width));
    }

    public Line(List<LadderPart> ladderParts) {
        checkLadderParts(ladderParts);
        this.ladderParts = ladderParts;
    }

    private void checkLadderParts(List<LadderPart> ladderParts) {
        if (MathFunction.EVEN_NUMBER.test(ladderParts.size())) {
            throw new IllegalArgumentException(INVALID_WIDTH_MESSAGE);
        }
        IntStream.range(INDEX_ZERO, ladderParts.size())
                .forEach(index -> checkLadderPartsPosition(index, ladderParts.get(index)));
        }

    private void checkLadderPartsPosition(int index, LadderPart ladderPart) {
        if (MathFunction.EVEN_NUMBER.test(index) && !ladderPart.isRail()) {
            throw new IllegalArgumentException(INVALID_PART_EVEN_RAIL_MESSAGE);
        }
        if (!MathFunction.EVEN_NUMBER.test(index) && ladderPart.isRail()) {
            throw new IllegalArgumentException(INVALID_PART_ODD_RUNG_MESSAGE);
        }
    }

    private static List<LadderPart> makeRandomLadderParts(int width) {
        if (width < MIN_WIDTH) {
            throw new IllegalArgumentException(Ladder.INVALID_WIDTH_HEIGHT_MESSAGE);
        }
        LadderPartFactory.initIsPreviousRungSet();
        return IntStream.range(INDEX_ZERO, width)
                .mapToObj(LadderPartFactory::ladderPart)
                .collect(Collectors.toList());
    }

    public int move(int position) {
        return IntStream.range(INDEX_ZERO, ladderParts.size())
                .filter(index -> index == position)
                .map(currentIndex -> moveIndex(currentIndex))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    private int moveIndex(int currentIndex) {
        if (canMoveToTheLeft(currentIndex)) {
            return currentIndex - MOVE_COUNT;
        }
        if (canMoveToTheRight(currentIndex)) {
            return currentIndex + MOVE_COUNT;
        }
        return currentIndex;
    }

    private boolean canMoveToTheLeft(int currentIndex) {
        return currentIndex > INDEX_ZERO
                && ladderParts.get(currentIndex - MOVE_CHECK_COUNT).isRung();
    }

    private boolean canMoveToTheRight(int currentIndex) {
        return currentIndex < ladderParts.size() - LADDER_PARTS_SIZE_TO_INDEX
                && ladderParts.get(currentIndex + MOVE_CHECK_COUNT).isRung();
    }

    public int width() {
        return ladderParts.size();
    }

    public List<LadderPart> getLadderParts() {
        return Collections.unmodifiableList(ladderParts);
    }
}
