package me.namuhuchutong.ladder.domain;

import me.namuhuchutong.ladder.domain.wrapper.LadderExpression;

public class ContinuousScaffoldValidator {

    private boolean flag;

    public ContinuousScaffoldValidator() {
        this.flag = false;
    }

    public boolean isContinuous(LadderExpression expression) {
        if (expression.isHyphen() && (flag)) {
            return true;
        }
        this.flag = expression.isHyphen();
        return false;
    }
}
