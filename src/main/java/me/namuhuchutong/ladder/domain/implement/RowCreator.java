package me.namuhuchutong.ladder.domain.implement;

import me.namuhuchutong.ladder.domain.engine.Line;
import me.namuhuchutong.ladder.domain.engine.LineCreator;
import me.namuhuchutong.ladder.domain.engine.ScaffoldGenerator;
import me.namuhuchutong.ladder.domain.implement.wrapper.LadderExpression;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.unmodifiableList;
import static me.namuhuchutong.ladder.domain.implement.wrapper.LadderExpression.*;

public class RowCreator implements LineCreator {

    private final ScaffoldGenerator scaffoldGenerator;

    public RowCreator(ScaffoldGenerator scaffoldGenerator) {
        this.scaffoldGenerator = scaffoldGenerator;
    }

    @Override
    public Line createLine(int participants) {
        return from(participants, scaffoldGenerator);
    }

    private Line from(int participants, ScaffoldGenerator factory) {
        List<LadderExpression> initializedRow = initializeLadderRow();
        initializedRow.addAll(addScaffold(participants, factory));
        return new Row(unmodifiableList(initializedRow));
    }

    private List<LadderExpression> addScaffold(int participants, ScaffoldGenerator generator) {
        List<LadderExpression> result = new ArrayList<>();
        PreviousStatus checker = new PreviousStatus();
        for (int i = 1; i < participants; i++) {
            result.add(addScaffoldByCondition(generator, checker));
            result.add(VERTICAL_BAR);
        }
        return result;
    }

    private LadderExpression addScaffoldByCondition(ScaffoldGenerator generator, PreviousStatus checker) {
        if (generator.canGenerate() && checker.isNotCreatedBefore()) {
            checker.setCreated();
            return HYPHEN;
        }
        checker.setNotCreated();
        return EMPTY_SPACE;
    }

    private List<LadderExpression> initializeLadderRow() {
        List<LadderExpression> list = new ArrayList<>();
        list.add(EMPTY_SPACE);
        list.add(VERTICAL_BAR);
        return list;
    }
}
