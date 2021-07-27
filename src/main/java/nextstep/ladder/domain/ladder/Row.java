package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.init.LadderInitInfo;
import nextstep.ladder.domain.strategy.StepGenerateStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static nextstep.ladder.domain.strategy.NeverGenerateStrategy.NEVER_GENERATE_STRATEGY;

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
        StepGenerateStrategy stepGenerateStrategy = selectStepGenerateStrategy(ladderInitInfo);

        columns.add(Column.initFirst(stepGenerateStrategy));
    }

    private StepGenerateStrategy selectStepGenerateStrategy(LadderInitInfo ladderInitInfo) {
        if (isLadderWidthSizeOne(ladderInitInfo)) {
            return NEVER_GENERATE_STRATEGY;
        }

        return ladderInitInfo.getStepGenerateStrategy();
    }

    private boolean isLadderWidthSizeOne(LadderInitInfo ladderInitInfo) {
        return ladderInitInfo.isEqualToWidth(ONE);
    }

    private void createMiddle(LadderInitInfo ladderInitInfo) {
        if (isColumnSizeUnderLadderWidthSize(ladderInitInfo)) {
            Stream.generate(() -> createNextColumn(ladderInitInfo.getStepGenerateStrategy()))
                    .limit(getMiddleColumnLimit(ladderInitInfo))
                    .forEach(columns::add);
        }
    }

    private int getMiddleColumnLimit(LadderInitInfo ladderInitInfo) {
        int limit = ladderInitInfo.getLadderWidth() - FIRST_AND_END_EXCEPT_COUNT;

        return Math.max(limit, ZERO);
    }

    private boolean isColumnSizeUnderLadderWidthSize(LadderInitInfo ladderInitInfo) {
        return ladderInitInfo.isUnderWidth(columns.size());
    }

    private void createLast(LadderInitInfo ladderInitInfo) {
        if (isColumnSizeUnderLadderWidthSize(ladderInitInfo)) {
            columns.add(createLastColumn());
        }
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

    public static Row init(LadderInitInfo ladderInitInfo) {
        return new Row(ladderInitInfo);
    }

    public List<Boolean> toSteps() {
        return columns.stream()
                .map(Column::hasRightStep)
                .collect(Collectors.toList());
    }
}
