package me.namuhuchutong.ladder.domain;

import me.namuhuchutong.ladder.domain.wrapper.*;
import me.namuhuchutong.ladder.domain.factory.ScaffoldFactory;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.*;
import static me.namuhuchutong.ladder.domain.wrapper.LadderExpression.*;

public class Row {

    private final List<LadderExpression> values;

    public static Row from(int participants, ScaffoldFactory factory) {
        List<LadderExpression> collect = initializeLadderRow();
        collect.addAll(addScaffold(participants, factory));
        return new Row(unmodifiableList(collect));
    }

    private static List<LadderExpression> addScaffold(int participants, ScaffoldFactory factory) {
        List<LadderExpression> result = new ArrayList<>();
        for (int i = 1; i < participants; i++) {
            result.add(factory.createScaffold());
            result.add(VERTICAL_BAR);
        }
        return result;
    }

    private static List<LadderExpression> initializeLadderRow() {
        List<LadderExpression> list = new ArrayList<>();
        list.add(EMPTY_SPACE);
        list.add(VERTICAL_BAR);
        return list;
    }

    public Row(List<LadderExpression> values) {
        validateContinuousScaffold(values);
        this.values = values;
    }

    private void validateContinuousScaffold(List<LadderExpression> values) {
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
                          .map(LadderExpression::convertToString)
                          .reduce("", (previous, newOne) -> previous + newOne);
    }
}
