package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.strategy.StepGenerateStrategy;

import java.util.List;

public class Row {

    private List<Column> columns;

    public Row(int ladderWidth, StepGenerateStrategy stepGenerateStrategy) {

    }

    public static Row init(int ladderWidth, StepGenerateStrategy stepGenerateStrategy) {
        return new Row(ladderWidth, stepGenerateStrategy);
    }
}
