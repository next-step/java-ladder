package me.namuhuchutong.ladder.domain;

import me.namuhuchutong.ladder.domain.wrapper.*;
import me.namuhuchutong.ladder.domain.factory.ScaffoldFactory;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.*;

public class Row {

    private final List<LadderExpression> values;

    public static Row from(int participants, ScaffoldFactory factory) {
        List<LadderExpression> collect = initializeLadderRow();
        addScaffold(participants, collect, factory);
        return new Row(unmodifiableList(collect));
    }

    private static void addScaffold(int participants,
                                    List<LadderExpression> collect,
                                    ScaffoldFactory factory) {
        for (int i = 1; i < participants; i++) {
            collect.add(factory.createScaffold());
            collect.add(new VerticalBar());
        }
    }

    private static List<LadderExpression> initializeLadderRow() {
        List<LadderExpression> list = new ArrayList<>();
        list.add(new EmptySpace());
        list.add(new VerticalBar());
        return list;
    }

    public Row(List<LadderExpression> values) {
        validateContinuousScaffold(values);
        this.values = values;
    }

    private void validateContinuousScaffold(List<LadderExpression> values) {
        Flag scaffoldFound = new Flag();
        values.stream()
              .filter(expression -> !(expression instanceof VerticalBar))
              .forEach(expression -> {
                  if ((expression instanceof Hyphen) && scaffoldFound.peek()) {
                      throw new IllegalArgumentException("사다리 발판은 연속적일 수 없습니다.");
                  }
                  scaffoldFound.setFlag(expression instanceof Hyphen);});
    }

    @Override
    public String toString() {
        return this.values.stream()
                          .map(LadderExpression::toString)
                          .reduce("", (previous, newOne) -> previous + newOne);
    }
}
