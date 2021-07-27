package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.init.LadderInitInfo;
import nextstep.ladder.domain.strategy.StepGenerateStrategy;

import java.util.List;

public class Row {

    private List<Column> columns;

    public Row(int ladderWidth, StepGenerateStrategy stepGenerateStrategy) {

    }

    public static boolean init(LadderInitInfo ladderInitInfo) {
        return false;
    }
}
