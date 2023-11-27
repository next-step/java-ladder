package me.namuhuchutong.ladder.domain.implement;

import me.namuhuchutong.ladder.domain.engine.Line;
import me.namuhuchutong.ladder.domain.implement.wrapper.LadderExpression;
import me.namuhuchutong.ladder.domain.implement.wrapper.Movements;

import java.util.List;

import static me.namuhuchutong.ladder.domain.implement.wrapper.Movements.*;

public class Row implements Line {

    private static final String BLANK = "";

    private final List<LadderExpression> values;

    public Row(List<LadderExpression> values) {
        validateContinuousScaffold(values);
        this.values = values;
    }

    private void validateContinuousScaffold(List<LadderExpression> values) {
        ContinuousScaffoldValidator validator = new ContinuousScaffoldValidator();
        values.stream()
              .filter(LadderExpression::isNotVerticalBar)
              .filter(validator::isContinuous)
              .findAny()
              .ifPresent(e -> {
                  throw new IllegalArgumentException("사다리 발판은 연속적일 수 없습니다.");
              });
    }

    @Override
    public int move(int startPoint) {
        Movements movement = findDestination(startPoint);
        return movement.move(startPoint);
    }

    private Movements findDestination(int startPoint) {
        LadderExpression left = findExpression(startPoint - 1);
        LadderExpression right = isEndOfCollection(startPoint) ?
                findExpression(startPoint) : findExpression(startPoint + 1);
        if (left.isHyphen()) {
            return MOVE_LEFT;
        }
        if (right.isHyphen()) {
            return MOVE_RIGHT;
        }
        return STOP;
    }

    private LadderExpression findExpression(int startPoint) {
        return this.values.get(startPoint);
    }

    private boolean isEndOfCollection(int startPoint) {
        return startPoint == this.values.size() - 1;
    }

    @Override
    public String toString() {
        return this.values.stream()
                          .map(LadderExpression::convertToString)
                          .reduce(BLANK, (previous, newOne) -> previous + newOne);
    }
}
