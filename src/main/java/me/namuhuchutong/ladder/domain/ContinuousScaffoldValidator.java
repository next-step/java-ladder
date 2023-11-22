package me.namuhuchutong.ladder.domain;

import me.namuhuchutong.ladder.domain.wrapper.LadderExpression;

import static me.namuhuchutong.ladder.domain.wrapper.LadderExpression.*;

public class ContinuousScaffoldValidator {

    private boolean flag;

    public ContinuousScaffoldValidator() {
        this.flag = false;
    }

    public boolean isContinuous(LadderExpression expression) {
        if (expression.equals(HYPHEN) && (flag)) {
            return true;
        }
        this.flag = expression.equals(HYPHEN);
        return false;
    }
}
