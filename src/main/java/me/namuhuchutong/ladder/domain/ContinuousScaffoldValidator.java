package me.namuhuchutong.ladder.domain;

import me.namuhuchutong.ladder.domain.wrapper.LadderExpressionEnum;

import static me.namuhuchutong.ladder.domain.wrapper.LadderExpressionEnum.*;

public class ContinuousScaffoldValidator {

    private boolean flag;

    public ContinuousScaffoldValidator() {
        this.flag = false;
    }

    public boolean isContinuous(LadderExpressionEnum expression) {
        if ((expression.equals(HYPHEN)) && (flag)) {
            return true;
        }
        this.flag = expression.equals(HYPHEN);
        return false;
    }
}
