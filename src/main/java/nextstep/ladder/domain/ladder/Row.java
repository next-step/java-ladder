package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.init.LadderInitInfo;
import nextstep.ladder.domain.strategy.StepGenerateStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Row {
    private static final int ONE = 1;
    private static final int ZERO = 0;
    private static final int FIRST_AND_END_EXCEPT_COUNT = 2;

    private final List<Column> columns;

    private Row(LadderInitInfo ladderInitInfo) {
        validate(ladderInitInfo);
        columns = new ArrayList<>(ladderInitInfo.getLadderWidth());

        createFirst(ladderInitInfo);
        createMiddle(ladderInitInfo);
        createLast(ladderInitInfo);
    }

    private void validate(LadderInitInfo ladderInitInfo) {
        if (Objects.isNull(ladderInitInfo)) {
            throw new IllegalArgumentException("LadderInitInfo can't be null");
        }
    }

    private void createFirst(LadderInitInfo ladderInitInfo) {
        StepGenerateStrategy stepGenerateStrategy = ladderInitInfo.getStepGenerateStrategy();

        if (isLadderWidthOne(ladderInitInfo)) {
            stepGenerateStrategy = () -> false;
        }

        columns.add(Column.initFirst(stepGenerateStrategy));
    }

    private boolean isLadderWidthOne(LadderInitInfo ladderInitInfo) {
        return ladderInitInfo.isEqualToWidth(ONE);
    }

    private void createMiddle(LadderInitInfo ladderInitInfo) {
        if (isColumnSizeUnderLadderWidth(ladderInitInfo)) {
            Stream.generate(() -> createNextColumn(ladderInitInfo.getStepGenerateStrategy()))
                    .limit(getMiddleColumnLimit(ladderInitInfo))
                    .forEach(columns::add);
        }
    }

    private int getMiddleColumnLimit(LadderInitInfo ladderInitInfo) {
        int limit = ladderInitInfo.getLadderWidth() - FIRST_AND_END_EXCEPT_COUNT;

        return Math.max(limit, ZERO);
    }

    private boolean isColumnSizeUnderLadderWidth(LadderInitInfo ladderInitInfo) {
        return ladderInitInfo.isUnderWidth(columns.size());
    }

    private void createLast(LadderInitInfo ladderInitInfo) {
        if (isColumnSizeUnderLadderWidth(ladderInitInfo)) {
            columns.add(createLastColumn());
        }
    }

    public static Row init(LadderInitInfo ladderInitInfo) {
        return new Row(ladderInitInfo);
    }

    private Column createNextColumn(StepGenerateStrategy stepGenerateStrategy) {
        return getLastColumn().initNext(stepGenerateStrategy);
    }

    private Column createLastColumn() {
        return getLastColumn().initLast();
    }

    private Column getLastColumn() {
        return columns.get(columns.size() - ONE);
    }

    public List<Boolean> toSteps() {
        return columns.stream()
                .map(Column::hasRightStep)
                .collect(Collectors.toList());
    }
}
