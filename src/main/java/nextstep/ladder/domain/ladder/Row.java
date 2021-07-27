package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.init.LadderInitInfo;
import nextstep.ladder.domain.strategy.StepGenerateStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class Row {
    private static final int ONE_OFFSET = 1;
    private static final int FIRST_AND_END_COUNT = 2;

    private final List<Column> columns;

    private Row(LadderInitInfo ladderInitInfo) {
        validate(ladderInitInfo);
        columns = new ArrayList<>(ladderInitInfo.getLadderWidth());

        createFirst(ladderInitInfo);
        createMiddle(ladderInitInfo);
        createLast();
    }

    private void validate(LadderInitInfo ladderInitInfo) {
        if (Objects.isNull(ladderInitInfo)) {
            throw new IllegalArgumentException("LadderInitInfo can't be null");
        }
    }

    private void createFirst(LadderInitInfo ladderInitInfo) {
        columns.add(Column.initFirst(ladderInitInfo.getStepGenerateStrategy()));
    }

    private void createMiddle(LadderInitInfo ladderInitInfo) {
        Stream.generate(() -> createNextColumn(ladderInitInfo.getStepGenerateStrategy()))
                .limit(ladderInitInfo.getLadderWidth() - FIRST_AND_END_COUNT)
                .forEach(columns::add);
    }

    private void createLast() {
        columns.add(createLastColumn());
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
        return columns.get(columns.size() - ONE_OFFSET);
    }

    public boolean toSteps() {
        return false;
    }
}
