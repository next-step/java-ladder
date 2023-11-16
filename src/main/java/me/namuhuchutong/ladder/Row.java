package me.namuhuchutong.ladder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Row {

    private final List<LadderExpression> values;

    public static Row from(int participants, ScaffoldFactory factory) {
        List<LadderExpression> collect = initializeLadderRow();
        addScaffold(participants, collect, factory);
        return new Row(Collections.unmodifiableList(collect));
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
        boolean scaffoldFound = false;
        for(LadderExpression expression : values) {
            if (expression.getValue().equals('|')) {
                continue;
            }
            if (expression.getValue().equals('-') && scaffoldFound) {
                throw new IllegalArgumentException("사다리 발판은 연속적일 수 없습니다.");
            }
            scaffoldFound = expression.getValue().equals('-');
        }
    }
}
