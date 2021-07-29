package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.init.LadderInitInfo;
import nextstep.ladder.domain.strategy.StepGenerateStrategy;
import nextstep.ladder.exception.NullArgumentException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LadderRow {
    public static final int ONE = 1;
    private static final int ZERO = 0;
    private static final int FIRST_AND_END_EXCEPT_COUNT = 2;

    private final List<LadderColumn> row;

    private LadderRow(LadderInitInfo ladderInitInfo) {
        validate(ladderInitInfo);
        row = new ArrayList<>(ladderInitInfo.getLadderWidth());

        createFirst(ladderInitInfo);
        createMiddle(ladderInitInfo);
        createLast(ladderInitInfo);
    }

    private void validate(LadderInitInfo ladderInitInfo) {
        if (Objects.isNull(ladderInitInfo)) {
            throw new NullArgumentException(LadderInitInfo.class);
        }
    }

    private void createFirst(LadderInitInfo ladderInitInfo) {
        row.add(LadderColumn.initFirst(ladderInitInfo.getStepGenerateStrategy()));
    }

    private void createMiddle(LadderInitInfo ladderInitInfo) {
        Stream.generate(() -> createNextColumn(ladderInitInfo.getStepGenerateStrategy()))
                .limit(getMiddleColumnLimit(ladderInitInfo))
                .forEach(row::add);
    }

    private int getMiddleColumnLimit(LadderInitInfo ladderInitInfo) {
        int limit = ladderInitInfo.getLadderWidth() - FIRST_AND_END_EXCEPT_COUNT;

        return Math.max(limit, ZERO);
    }

    private void createLast(LadderInitInfo ladderInitInfo) {
        if (!ladderInitInfo.isLadderWidthEqualTo(ONE)) {
            row.add(createLastColumn());
        }
    }

    private LadderColumn createNextColumn(StepGenerateStrategy stepGenerateStrategy) {
        return getLastColumn().initNext(stepGenerateStrategy);
    }

    private LadderColumn createLastColumn() {
        return getLastColumn().initLast();
    }

    private LadderColumn getLastColumn() {
        return row.get(row.size() - ONE);
    }

    public static LadderRow init(LadderInitInfo ladderInitInfo) {
        return new LadderRow(ladderInitInfo);
    }

    public LadderPosition ride(LadderPosition curPosition) {
        return columnOf(curPosition).ride(curPosition);
    }

    private LadderColumn columnOf(LadderPosition curPosition) {
        return row.get(curPosition.toInt());
    }

    public int ladderWidth() {
        return row.size();
    }

    public List<Boolean> toSteps() {
        return row.stream()
                .map(LadderColumn::hasRightStep)
                .collect(Collectors.toList());
    }
}
