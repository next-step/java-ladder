package step2.domain;

import static step2.view.ViewConstants.LADDER_BRIDGE;
import static step2.view.ViewConstants.LADDER_EMPTY;

import java.util.function.Function;

public enum LadderType {
    EMPTY(LADDER_EMPTY, col -> col),
    LEFT(LADDER_BRIDGE, col -> col - 1),
    RIGHT(LADDER_EMPTY, col -> col + 1);

    private String ladder;
    private Function<Integer, Integer> expression;

    LadderType(String ladder, Function<Integer, Integer> expression) {
        this.ladder = ladder;
        this.expression = expression;
    }

    public String ladder() {
        return this.ladder;
    }

    public Integer nextCol(int col) {
        return expression.apply(col);
    }
}
