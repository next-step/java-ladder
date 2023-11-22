package me.namuhuchutong.ladder.domain;

import me.namuhuchutong.ladder.domain.factory.ScaffoldFactory;
import me.namuhuchutong.ladder.domain.wrapper.Movements;
import me.namuhuchutong.ladder.domain.wrapper.Point;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.*;
import static me.namuhuchutong.ladder.domain.wrapper.LadderExpression.*;
import static me.namuhuchutong.ladder.domain.wrapper.Movements.*;

public class Row {

    private final List<Point> values;

    public static Row from(int participants, ScaffoldFactory factory) {
        List<Point> initializedRow = initializeLadderRow();
        initializedRow.addAll(addScaffold(participants, factory));
        return new Row(unmodifiableList(initializedRow));
    }

    private static List<Point> addScaffold(int participants, ScaffoldFactory factory) {
        List<Point> result = new ArrayList<>();
        for (int i = 1; i < participants; i++) {
            result.add(new Point(factory));
            result.add(new Point(VERTICAL_BAR));
        }
        return result;
    }

    private static List<Point> initializeLadderRow() {
        List<Point> list = new ArrayList<>();
        list.add(new Point(EMPTY_SPACE));
        list.add(new Point(VERTICAL_BAR));
        return list;
    }

    public Row(List<Point> values) {
        validateContinuousScaffold(values);
        this.values = values;
    }

    private void validateContinuousScaffold(List<Point> values) {
        ContinuousScaffoldValidator validator = new ContinuousScaffoldValidator();
        values.stream()
              .filter(Point::isNotVerticalBar)
              .filter(validator::isContinuous)
              .findAny()
              .ifPresent(e -> {
                  throw new IllegalArgumentException("사다리 발판은 연속적일 수 없습니다.");
              });
    }

    public int move(int startPoint) {
        Movements movement = findDestination(startPoint);
        return movement.move(startPoint);
    }

    private Movements findDestination(int startPoint) {
        Point left = this.values.get(startPoint - 1);
        Point right = startPoint == this.values.size() - 1 ?
                this.values.get(startPoint) : this.values.get(startPoint + 1);
        if (left.isHyphen()) {
            return MOVE_LEFT;
        }
        if (right.isHyphen()) {
            return MOVE_RIGHT;
        }
        return STOP;
    }

    @Override
    public String toString() {
        return this.values.stream()
                          .map(Point::convertToString)
                          .reduce("", (previous, newOne) -> previous + newOne);
    }
}
