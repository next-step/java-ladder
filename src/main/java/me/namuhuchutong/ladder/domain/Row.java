package me.namuhuchutong.ladder.domain;

import me.namuhuchutong.ladder.domain.wrapper.*;
import me.namuhuchutong.ladder.domain.factory.ScaffoldFactory;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.*;
import static me.namuhuchutong.ladder.domain.wrapper.LadderExpressionEnum.*;

public class Row {

    private final List<LadderExpressionEnum> values;

    public static Row from(int participants, ScaffoldFactory factory) {
        List<LadderExpressionEnum> collect = initializeLadderRow();
        addScaffold(participants, collect, factory);
        return new Row(unmodifiableList(collect));
    }

    private static void addScaffold(int participants,
                                    List<LadderExpressionEnum> collect,
                                    ScaffoldFactory factory) {
        for (int i = 1; i < participants; i++) {
            collect.add(factory.createScaffold());
            collect.add(VERTICAL_BAR);
        }
    }

    private static List<LadderExpressionEnum> initializeLadderRow() {
        List<LadderExpressionEnum> list = new ArrayList<>();
        list.add(EMPTY_SPACE);
        list.add(VERTICAL_BAR);
        return list;
    }

    public Row(List<LadderExpressionEnum> values) {
        validateContinuousScaffold(values);
        this.values = values;
    }

    private void validateContinuousScaffold(List<LadderExpressionEnum> values) {
        ContinuousScaffoldValidator validator = new ContinuousScaffoldValidator();
        values.stream()
              .filter(expression -> !expression.equals(VERTICAL_BAR))
              .filter(validator::isContinuous)
              .findAny()
              .ifPresent(e -> {
                  throw new IllegalArgumentException("사다리 발판은 연속적일 수 없습니다.");
              });
    }

    @Override
    public String toString() {
        return this.values.stream()
                          .map(LadderExpressionEnum::convertToString)
                          .reduce("", (previous, newOne) -> previous + newOne);
    }
}
