package me.namuhuchutong.ladder.domain;

import me.namuhuchutong.ladder.domain.factory.ScaffoldFactory;
import me.namuhuchutong.ladder.domain.wrapper.LadderExpression;
import me.namuhuchutong.ladder.domain.wrapper.Movements;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.*;
import static me.namuhuchutong.ladder.domain.wrapper.LadderExpression.*;
import static me.namuhuchutong.ladder.domain.wrapper.Movements.*;

public class Row {

    private final List<LadderExpression> values;

    public static Row from(int participants, ScaffoldFactory factory) {
        List<LadderExpression> initializedRow = initializeLadderRow();
        initializedRow.addAll(addScaffold(participants, factory));
        return new Row(unmodifiableList(initializedRow));
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
              .filter(this::filteringVerticalBar)
              .filter(validator::isContinuous)
              .findAny()
              .ifPresent(e -> {
                  throw new IllegalArgumentException("사다리 발판은 연속적일 수 없습니다.");
              });
    }

    private boolean filteringVerticalBar(LadderExpression expression) {
        return expression.equals(HYPHEN);
    }

    public int move(int startPoint) {
        Movements movement = findDestination(startPoint);
        return movement.move(startPoint);
    }

    private Movements findDestination(int startPoint) {
        LadderExpression left = this.values.get(startPoint - 1);
        LadderExpression right = startPoint == this.values.size() - 1 ?
                this.values.get(startPoint) : this.values.get(startPoint + 1);
        if (left.equals(HYPHEN)) {
            return MOVE_LEFT;
        }
        if (right.equals(HYPHEN)) {
            return MOVE_RIGHT;
        }
        return STOP;
    }

    @Override
    public String toString() {
        return this.values.stream()
                          .map(LadderExpression::convertToString)
                          .reduce("", (previous, newOne) -> previous + newOne);
    }
}
