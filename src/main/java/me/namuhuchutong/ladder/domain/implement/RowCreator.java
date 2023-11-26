package me.namuhuchutong.ladder.domain.implement;

import me.namuhuchutong.ladder.domain.engine.Line;
import me.namuhuchutong.ladder.domain.engine.LineCreator;
import me.namuhuchutong.ladder.domain.engine.ScaffoldDiscriminator;
import me.namuhuchutong.ladder.domain.implement.wrapper.LadderExpression;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.unmodifiableList;
import static me.namuhuchutong.ladder.domain.implement.wrapper.LadderExpression.*;

public class RowCreator implements LineCreator {

    @Override
    public Line createLine(int participants, ScaffoldDiscriminator factory) {
        return from(participants, factory);
    }

    private Line from(int participants, ScaffoldDiscriminator factory) {
        List<LadderExpression> initializedRow = initializeLadderRow();
        initializedRow.addAll(addScaffold(participants, factory));
        return new Row(unmodifiableList(initializedRow));
    }

    private List<LadderExpression> addScaffold(int participants, ScaffoldDiscriminator factory) {
        List<LadderExpression> result = new ArrayList<>();
        for (int i = 1; i < participants; i++) {
            result.add(addScaffoldByCondition(factory));
            result.add(VERTICAL_BAR);
        }
        return result;
    }

    private LadderExpression addScaffoldByCondition(ScaffoldDiscriminator discriminator) {
        if (discriminator.isNotCreatedBefore()) {
            return HYPHEN;
        }
        return EMPTY_SPACE;
    }

    private List<LadderExpression> initializeLadderRow() {
        List<LadderExpression> list = new ArrayList<>();
        list.add(EMPTY_SPACE);
        list.add(VERTICAL_BAR);
        return list;
    }
}
